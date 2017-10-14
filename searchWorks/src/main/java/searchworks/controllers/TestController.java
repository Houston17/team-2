package searchworks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import searchworks.repo.PersonRepo;
import searchworks.repo.eventsRepo;
import searchworks.model.Person;
import searchworks.model.Event;


@Controller
public class TestController {
	
	@Autowired
	private PersonRepo personRepo;

	@Autowired
	private eventsRepo eventRepo; // Table name = events

	
	
	@RequestMapping(value="/")
	public ModelAndView homePage(){
		
		List<Person> people = personRepo.findAll();
		List<Event> events = eventRepo.findAll();
		//List<eventvolunteer> ev = eventvolunteer
		
		
		for(Person p: people){
			
			System.out.println(p);
		}
		
		System.out.println("=========================");
		
		for(Event e: events) {
			System.out.println(e);
		}
		
		ModelAndView mv = new ModelAndView("home");
		mv.getModel().put("name", "searchWorks");
		mv.getModel().put("events", events);
		return mv;
	}

}
