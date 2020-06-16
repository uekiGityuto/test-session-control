package sample.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class WebController {

	@GetMapping(path = "index")
	String gotoIndex(Model model) {
		return "index";
	}
	
	@GetMapping(path = "loginResult")
	String gotoLoginResult(Model model) {
		return "loginResult";
	}

}

