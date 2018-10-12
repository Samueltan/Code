package test.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * author: Antonella Solomon
 *
 */

@Controller
/**
 * Option 1: url-pattern in web.xml uses '/api/*', here the controller doesn't use mapping '/api', or:
 * Option 2: url-pattern in web.xml uses '/', here uses mapping '/api'
 */
@RequestMapping("/api")
public class HomeController {

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>This message is coming from HomeController.java</h3>";
		return new ModelAndView("welcome", "message", message);
	}

	@RequestMapping("/hello")
	public String helloWorld2() {

		return "welcome";
	}

}
