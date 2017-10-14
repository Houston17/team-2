package searchworks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping(value="/")
	public ModelAndView homePage(){
		ModelAndView mv = new ModelAndView("home");
		mv.getModel().put("name", "searchWorks");
		return mv;
	}

}
