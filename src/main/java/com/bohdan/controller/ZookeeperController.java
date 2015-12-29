package com.bohdan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bohdan.model.Animal;
import com.bohdan.model.Zookeeper;
import com.bohdan.service.AnimalService;
import com.bohdan.service.ZookeeperService;

@Controller
public class ZookeeperController {
	@Autowired
	private ZookeeperService service;
	
	@Autowired
	private AnimalService animalService;

	@RequestMapping(value = "/createZookeeper")
	public String createPet(Model model) {
		List<Animal> animals = animalService.getAll();
		model.addAttribute("animals", animals);
		return "zookeeper-new";
	}

	@RequestMapping(value = "/showAllZookeepers")
	public String showAllZookeepers(Model model) {
		List<Zookeeper> zookeepers = service.getAll();
		model.addAttribute("zookeepers", zookeepers);
		return "zookeeper-all";
	}

	@RequestMapping(value = "/showAllZookeepers", method = RequestMethod.POST)
	public String createZookeeper(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName, @RequestParam(value = "animalId[]") String[] animalId) {
//		int id = Integer.parseInt(animalId);
		service.insert(firstName, lastName, animalId);
		return "redirect:/showAllZookeepers";
	}

	@RequestMapping(value = "/deleteZookeeper")
	public String deleteZookeeper(Model model) {
		List<Zookeeper> zookeepers = service.getAll();
		model.addAttribute("zookeepers", zookeepers);
		return "zookeeper-delete";
	}

	@RequestMapping(value = "/deleteZookeeper", method = RequestMethod.POST)
	public String deleteAnimal(@RequestParam(value = "zookeeperId") String zookeeperId) {
		int id = Integer.parseInt(zookeeperId);
		service.delete(id);
		return "redirect:/showAllZookeepers";
	}

	@RequestMapping(value = "/editZookeeper")
	public String editZookeeper(Model model) {
		List<Zookeeper> zookeepers = service.getAll();
		model.addAttribute("zookeepers", zookeepers);
		List<Animal> animals = animalService.getAll();
		model.addAttribute("animals", animals);
		return "zookeeper-edit";
	}

	@RequestMapping(value = "/editZookeeper", method = RequestMethod.POST)
	public String editPerson(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName, @RequestParam(value = "id") String id) {
		int idInt = Integer.parseInt(id);
		service.edit(idInt, firstName, lastName);
		return "redirect:/showAllZookeepers";
	}
	
//	@RequestMapping(value = "/editZookeeper", method = RequestMethod.POST)
//	public String editPerson(@RequestParam(value = "firstName") String firstName,
//			@RequestParam(value = "lastName") String lastName, @RequestParam(value = "id") String id) {
//		int idInt = Integer.parseInt(id);
//		service.edit(idInt, firstName, lastName);
//		return "redirect:/showAllZookeepers";
//	}
	
	@RequestMapping(value = "/findZookeeperByName")
	public String findZookeeperByName(Model model) {
		List<Zookeeper> zookeepers = service.getAll();
		model.addAttribute("zookeepers", zookeepers);
		return "zookeeper-findByName";
	}

	@RequestMapping(value = "/findZookeeperByName", method = RequestMethod.POST)
	public String findZookeeperByName(Model model, @RequestParam(value = "name") String name) {
		List<Zookeeper> zookeepers = service.findByFirstName(name);
		model.addAttribute("zookeepers", zookeepers);
		return "zookeeper-findResult";
	}
	
	@RequestMapping(value = "/findZookeeperByFirstAndLastName")
	public String findZookeeperByFirstAndLastName() {
		return "zookeeper-findByFirstAndLastName";
	}

	@RequestMapping(value = "/findZookeeperByFirstAndLastName", method = RequestMethod.POST)
	public String findZookeeperByFirstAndLastName(Model model, @RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName) {
		List<Zookeeper> zookeepers = service.findByFirstAndLastName(firstName, lastName);
		model.addAttribute("zookeepers", zookeepers);
		return "zookeeper-findResultNew";
	}

}
