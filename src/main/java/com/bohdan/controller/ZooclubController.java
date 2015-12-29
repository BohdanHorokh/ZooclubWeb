package com.bohdan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bohdan.model.Animal;
import com.bohdan.model.Zooclub;
import com.bohdan.service.ZooclubService;

@Controller
public class ZooclubController {
	@Autowired
	private ZooclubService zooclubService;
	
	@RequestMapping(value = "/createZooclub")
	public String createZooclub() {
		return "zooclub-new";
	}
	
	@RequestMapping(value = "/showAllZooclubs")
	public String showAllZooclubs(Model model) {
		List<Zooclub> zooclubs = zooclubService.getAll();
		model.addAttribute("zooclubs", zooclubs);
		return "zooclub-all";
	}
	
	@RequestMapping(value = "/showAllZooclubs", method = RequestMethod.POST)
	public String createZooclub(@RequestParam(value ="name") String name) {
		zooclubService.insert(name);
		return "redirect:/showAllZooclubs";
	}
	
	@RequestMapping(value = "/deleteZooclub")
	public String deleteZooclub(Model model) {
		List<Zooclub> zooclubs = zooclubService.getAll();
		model.addAttribute("zooclubs", zooclubs);
		return "zooclub-delete";
	}
	
	@RequestMapping(value = "/deleteZooclub", method = RequestMethod.POST)
	public String deleteZooclub(@RequestParam(value = "zooclubId") String zooclubId) {
		int id = Integer.parseInt(zooclubId);
		zooclubService.delete(id);
		return "redirect:/showAllZooclubs";
	}
	
	@RequestMapping(value = "/editZooclub")
	public String editZooclub(Model model) {
		List<Zooclub> zooclubs = zooclubService.getAll();
		model.addAttribute("zooclubs", zooclubs);
		return "zooclub-edit";
	}

	@RequestMapping(value = "/editZooclub", method = RequestMethod.POST)
	public String editZooclub(@RequestParam(value = "zooclubId") String id, @RequestParam(value = "name") String name) {
		int idInt = Integer.parseInt(id);
		zooclubService.edit(idInt, name);
		return "redirect:/showAllZooclubs";
	}
	
	@RequestMapping(value = "/findZooclubByName")
	public String findAnimalByName(Model model) {
		List<Zooclub> zooclubs = zooclubService.getAll();
		model.addAttribute("zooclubs", zooclubs);
		return "zooclub-findByName";
	}

	@RequestMapping(value = "/findZooclubByName", method = RequestMethod.POST)
	public String findPersonByName(Model model, @RequestParam(value = "name") String name) {
		List<Zooclub> zooclubs = zooclubService.findByName(name);
		model.addAttribute("zooclubs", zooclubs);
		return "zooclub-findResult";
	}
}
