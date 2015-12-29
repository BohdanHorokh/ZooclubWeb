package com.bohdan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bohdan.model.Person;
import com.bohdan.model.Zooclub;
import com.bohdan.service.PersonService;
import com.bohdan.service.ZooclubService;

@Controller
public class PersonController {
	@Autowired
	private PersonService personService;
	@Autowired
	private ZooclubService zooclubService;

	@RequestMapping(value = "/showAllPersons")
	public String getAllPersons(Model model) {
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("allPersons", persons);
		return "person-all";
	}

	@RequestMapping(value = "/showAllPersons", method = RequestMethod.POST)
	public String createPerson(@RequestParam(value = "name") String name, 
			@RequestParam(value = "age") String age, @RequestParam(value = "zooclubId") String zooclubId) {
		int ageInt = Integer.parseInt(age);
		int zooId = Integer.parseInt(zooclubId);
		personService.insertPerson(name, ageInt, zooId);
		return "redirect:/showAllPersons";
	}

	@RequestMapping(value = "/deletePerson", method = RequestMethod.POST)
	public String deletePerson(@RequestParam(value = "id") String personId) {
		int id = Integer.parseInt(personId);
		personService.deletePerson(id);
		return "redirect:/showAllPersons";
	}

	@RequestMapping(value = "/editPerson", method = RequestMethod.POST)
	public String editPerson(@RequestParam(value = "name") String name, @RequestParam(value = "age") String age,
			@RequestParam(value = "id") String id) {
		int ageInt = Integer.parseInt(age);
		int idInt = Integer.parseInt(id);
		personService.editPerson(idInt, name, ageInt);
		return "redirect:/showAllPersons";
	}

	@RequestMapping(value = "/createPerson")
	public String createPersonPage(Model model) {
		List<Zooclub> zooclubs = zooclubService.getAll();
		model.addAttribute("zooclubs", zooclubs);	
		return "person-new";
	}

	@RequestMapping(value = "/deletePerson")
	public String deletePerson(Model model) {
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("persons", persons);
		return "person-delete";
	}

	@RequestMapping(value = "/editPerson")
	public String editPerson(Model model) {
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("persons", persons);
		return "person-edit";
	}
	
	@RequestMapping(value ="/findPersonByName")
	public String findPersonByName(Model model) {
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("persons", persons);
		return "person-findByName";
	}
	
	@RequestMapping(value = "/findPersonByName", method = RequestMethod.POST)
	public String findPersonByName(Model model, @RequestParam(value = "name") String name) {
		List<Person> persons = personService.findPersonByName(name);
		model.addAttribute("persons", persons);
		return "person-findByNameResult";
	}
	
	@RequestMapping(value = "/home")
	public String goHomePage(){
		return "home";
	}
}
