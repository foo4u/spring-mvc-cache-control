package net.rossillo.spring.web.mvc;

import org.springframework.stereotype.Controller;

import static net.rossillo.spring.web.mvc.Times.*;

@CacheControl(policy = CachePolicy.PRIVATE)
@Controller
final class CacheControlAnnotatedTestController {
	
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = DAY)
	public String handlePubliclyCachedPageRequest() {
		return null;
	}
	
	@CacheControl(policy = {CachePolicy.MUST_REVALIDATE}, maxAge = 5 * HOUR)
	public String handlePubliclyCachedPageAndRevalidatedRequest() {
		return null;
	}
	
	@CacheControl(policy = {CachePolicy.PUBLIC, CachePolicy.PROXY_REVALIDATE}, maxAge = 2 * WEEK)
	public String handlePubliclyCachedPageAndProxyRevalidatedRequest() {
		return null;
	}
	
	@CacheControl(policy = CachePolicy.PRIVATE, maxAge = MONTH)
	public String handlePrivatelyCachedPageRequest() {
		return null;
	}
	
	public String handleWithDefaultPolicy() {
		return null;
	}
	
}
