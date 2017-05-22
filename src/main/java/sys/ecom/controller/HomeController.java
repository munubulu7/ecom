package sys.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/app")
	public String index() {
		return "index";
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public String error404() {
		return "404";
	}

	public class ResourceNotFoundException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	}
}
