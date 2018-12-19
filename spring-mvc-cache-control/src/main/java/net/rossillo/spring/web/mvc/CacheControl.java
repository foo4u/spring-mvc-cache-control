package net.rossillo.spring.web.mvc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Provides an HTTP 1.1 cache control header annotation for
 * Spring MVC controller methods.
 *
 * See also http://www.mnot.net/cache_docs/
 *
 * @author Scott Rossillo
 *
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheControl {

	/**
	 * The <code>cache-control</code> policies to apply to the response.
	 *
	 * @see CachePolicy
	 */
	CachePolicy[] policy() default { CachePolicy.NO_CACHE };

	/**
	 *  The maximum amount of time, in seconds, that this content will be considered fresh.
	 */
	int maxAge() default 0;

	/**
	 * The maximum amount of time, in seconds, that this content will be considered fresh
	 * only for shared caches (e.g., proxy) caches.
	 */
	int sharedMaxAge() default -1;

	/**
	 * Sometimes caching need vary headers. E.g. 'Accept'.
	 */
	String[] vary() default {};

}
