package searchworks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import searchworks.repo.PersonRepo;
import searchworks.model.Person;

@Controller
public class TestController {
	
	@Autowired
	private PersonRepo personRepo;
	
	@RequestMapping(value="/")
	public ModelAndView homePage(){
		
		List<Person> people = personRepo.findAll();
	
		for(Person p: people){
			
			System.out.println(p);
		}
		
		ModelAndView mv = new ModelAndView("home");
		mv.getModel().put("name", "searchWorks");
		return mv;
	}

}
