package net.rossillo.spring.web.mvc;

import org.springframework.stereotype.Controller;

@CacheControl(policy = CachePolicy.PRIVATE)
@Controller
final class CacheControlAnnotatedTestController {
	
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = 60)
	public String handlePubliclyCachedPageRequest() {
		return null;
	}
	
	@CacheControl(policy = { CachePolicy.PUBLIC, CachePolicy.MUST_REVALIDATE })
	public String handlePubliclyCachedPageAndRevalidatedRequest() {
		return null;
	}
	
	@CacheControl(policy = { CachePolicy.PUBLIC, CachePolicy.PROXY_REVALIDATE })
	public String handlePubliclyCachedPageAndProxyRevalidatedRequest() {
		return null;
	}
	
	@CacheControl(policy = CachePolicy.PRIVATE, maxAge = 360)
	public String handlePrivatelyCachedPageRequest() {
		return null;
	}
	
}
