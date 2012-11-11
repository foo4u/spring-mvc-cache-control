package net.rossillo.spring.web.mvc;

/**
 * Provides an enumeration of cache control policies.
 *
 * @author Scott Rossillo
 *
 */
public enum CachePolicy {
	
	/**
	 * Forces caches to submit the request to the origin server for validation before 
	 * releasing a cached copy.  Useful to assure that authentication is respected 
	 * (in combination with public), or to maintain rigid freshness, without sacrificing 
	 * all of the benefits of caching.
	 */
	NO_CACHE("no-cache"),
	
	/**
	 * Instructs caches not to keep a copy of the representation under any conditions. 
	 */
	NO_STORE("no-store"),
	
	/**
	 * Tells caches that they must obey any freshness information you give them.
	 * HTTP allows caches to serve stale representations under special conditions; 
	 * by specifying this policy, you're telling the cache that you want it to 
	 * strictly follow your rules.
	 */
	MUST_REVALIDATE("must-revalidate"),
	
	/**
	 * Similar to {@link CachePolicy#MUST_REVALIDATE}, except that it only applies to proxy caches.
	 */
	PROXY_REVALIDATE("proxy-revalidate"),
	
	/**
	 * Allows caches that are specific to one user (e.g., in a browser) to store 
	 * the response; shared caches (e.g., in a proxy) may not.
	 */
	PRIVATE("private"),
	
	/**
	 * Marks authenticated responses as cacheable.  Normally, if HTTP authentication 
	 * is required, responses are automatically private.
	 */
	PUBLIC("public");
	
	private final String policy;
	
	/**
	 * Creates a new, empty policy.
	 */
	CachePolicy() {
		this.policy = null;
	}
	
	/**
	 * Creates a new cache policy with the given Cache-Control header value.
	 * 
	 * @param policy the Cache-Control header value for this policy
	 */
	CachePolicy(final String policy) {
		this.policy = policy;
	}
	
	/**
	 * Returns the HTTP <code>cache-control</code> header value for this policy.
	 */
	public String policy() {
		return this.policy;
	}
}
