package net.rossillo.spring.web.mvc.demo;

import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Demonstrates usage of <code>@CacheControl</code> annotations on a 
 * Spring MVC controller.
 * 
 * @author Scott Rossillo
 *
 */
@Controller
public final class DemoController {

	/**
	 * Public home page, cacheable for 5 minutes.
	 */
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = 300)
	@RequestMapping({"/", "/home.do"})
	public String handleHomePageRequest(Model model) {
		model.addAttribute("pageName", "Home");
		return "page";
	}
	
	/**
	 * Directions page allowing for caching for 6 minutes, but requiring 
	 * re-revalidation before serving user a potentially stale resource.
	 */
	@CacheControl(policy = { CachePolicy.PUBLIC, CachePolicy.MUST_REVALIDATE }, maxAge = 360)
	@RequestMapping("/directions.do")
	public String handleProducDirectionsRequest(Model model) {
		model.addAttribute("pageName", "Directions");
		return "page";
	}
	
	/**
	 * Personalized accounts page.  Content is private to the user
	 * so it should only be stored in a private cache.
	 */
	@CacheControl(policy = { CachePolicy.PRIVATE, CachePolicy.MUST_REVALIDATE }) 
	@RequestMapping("/account.do")
	public String handleAccountRequest(Model model) {
		model.addAttribute("pageName", "Your Account");
		return "page";
	}
	
	@CacheControl(policy = { CachePolicy.PRIVATE, CachePolicy.MUST_REVALIDATE })
	@RequestMapping("/balance.do")
	public String handleBalancePageRequest(Model model) {
		model.addAttribute("pageName", "Account Balanace");
		return "page";
	}
	
	/**
	 * About page products no Cache-Control header.
	 */
	@RequestMapping("/about.do")
	public String handleItemRequest(Model model) {
		model.addAttribute("pageName", "About");
		return "page";
	}
}
