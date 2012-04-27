package net.rossillo.spring.web.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Provides a cache control handler interceptor to assign cache-control
 * headers to HTTP responses.
 * 
 * @author Scott Rossillo
 *
 */
public class CacheControlHandlerInterceptor extends HandlerInterceptorAdapter implements HandlerInterceptor {

	private static final String HEADER_EXPIRES = "Expires";
	private static final String HEADER_CACHE_CONTROL = "Cache-Control";
	
	/**
	 * Creates a new cache control handler interceptor.
	 */
	public CacheControlHandlerInterceptor() {
		super();
	}
	
	/**
	 * Assigns a <code>CacheControl</code> header to the given <code>response</code>.
	 * 
	 * @param request the <code>HttpServletRequest</code>
	 * @param response the <code>HttpServletResponse</code>
	 * @param handler the handler for the given <code>request</code>
	 */
	protected final void assignCacheControlHeader(
			final HttpServletRequest request,
			final HttpServletResponse response, 
			final Object handler) {
		
		String cacheControl = this.cacheControl(request, response, handler);
		
		if (cacheControl != null) {
			response.setHeader(HEADER_CACHE_CONTROL, cacheControl);
			/*
			if(response.containsHeader(HEADER_EXPIRES)) {
				response.setHeader(HEADER_EXPIRES, null);
			}
			*/
		}
	}
	
	/**
	 * Returns cache control header value for the given request, response
	 * and handler.
	 * 
	 * @param request the <code>HttpServletRequest</code>
	 * @param response the <code>HttpServletResponse</code>
	 * @param handler the handler for the given <code>request</code>
	 * 
	 * @return the cache control header value
	 */
	protected final String cacheControl(
			final HttpServletRequest request,
			final HttpServletResponse response, 
			final Object handler) {
		
		final StringBuilder builder = new StringBuilder();
		
		if (handler != null && handler instanceof HandlerMethod) {
			
			final HandlerMethod handlerMethod = (HandlerMethod) handler;
			final CacheControl cacheControl = handlerMethod.getMethodAnnotation(CacheControl.class);
	
			if (cacheControl != null) {
				
				final CachePolicy[] policies = cacheControl.policy();
				
				if (cacheControl.maxAge() >= 0) {
					builder.append("max-age=").append(cacheControl.maxAge());
				}
				
				if (cacheControl.sharedMaxAge() >= 0) {
					if (builder.length() > 0) {
						builder.append(", ");
					}
					builder.append("s-maxage=").append(cacheControl.sharedMaxAge());
				}
				
				if (policies != null) {
					for (final CachePolicy policy : policies) {
						if (builder.length() > 0) {
							builder.append(", ");
						}
						builder.append(policy.policy());
					}
				}
			}
		}
		
		return (builder.length() > 0 ? builder.toString() : null);
	}

	@Override
	public final boolean preHandle(
			final HttpServletRequest request,
			final HttpServletResponse response, 
			final Object handler) throws Exception {
		
		this.assignCacheControlHeader(request, response, handler);
		
		return super.preHandle(request, response, handler);
	}
}
