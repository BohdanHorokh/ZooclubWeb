package com.bohdan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bohdan.model.Animal;
import com.bohdan.model.Person;
import com.bohdan.service.AnimalService;
import com.bohdan.service.PersonService;
import com.bohdan.service.ZookeeperService;

@Controller
public class AnimalController {

	@Autowired
	private AnimalService animalService;
	@Autowired
	private PersonService personService;
	@Autowired
	private ZookeeperService service;

	@RequestMapping(value = "/showAllAnimals")
	public String showAllAnimals(Model model) {
		List<Animal> animals = animalService.getAll();
		model.addAttribute("animals", animals);
		return "animal-all";
	}

	@RequestMapping(value = "/createAnimal")
	public String createPersonPage(Model model) {
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("persons", persons);
		return "animal-new";
	}

	@RequestMapping(value = "/showAllAnimals", method = RequestMethod.POST)
	public String createAnimal(@RequestParam(value = "name") String name,
			@RequestParam(value = "personId") String personId, @RequestParam(value = "type") String type) {
		int personIdInt = Integer.parseInt(personId);
		animalService.insert(name, type, personIdInt);
		return "redirect:/showAllAnimals";
	}

	@RequestMapping(value = "/deleteAnimal")
	public String deleteAnimal(Model model) {
		List<Animal> animals = animalService.getAll();
		model.addAttribute("animals", animals);
		return "animal-delete";
	}

	@RequestMapping(value = "/deleteAnimal", method = RequestMethod.POST)
	public String deleteAnimal(@RequestParam(value = "animalId") String animalId) {
		int id = Integer.parseInt(animalId);
		animalService.delete(id);
		return "redirect:/showAllAnimals";
	}

	@RequestMapping(value = "/editAnimal")
	public String editAnimal(Model model) {
		List<Animal> animals = animalService.getAll();
		model.addAttribute("animals", animals);
		return "animal-edit";
	}

	@RequestMapping(value = "/editAnimal", method = RequestMethod.POST)
	public String editPerson(@RequestParam(value = "name") String name, @RequestParam(value = "animalId") String id) {
		int idInt = Integer.parseInt(id);
		animalService.edit(idInt, name);
		return "redirect:/showAllAnimals";
	}

	@RequestMapping(value = "/findAnimalByName")
	public String findAnimalByName(Model model) {
		List<Animal> animals = animalService.getAll();
		model.addAttribute("animals", animals);
		return "animal-findByName";
	}

	@RequestMapping(value = "/findAnimalByName", method = RequestMethod.POST)
	public String findPersonByName(Model model, @RequestParam(value = "name") String name) {
		List<Animal> animals = animalService.findByName(name);
		model.addAttribute("animals", animals);
		return "animal-findByNameResult";
	}
}
