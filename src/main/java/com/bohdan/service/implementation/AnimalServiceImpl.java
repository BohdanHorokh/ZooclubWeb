package com.bohdan.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bohdan.dao.AnimalDAO;
import com.bohdan.model.Animal;
import com.bohdan.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	private AnimalDAO animalDAO;

	public void insert(String name, String type, int personId) {
		animalDAO.insert(name, type, personId);
	}

	public void delete(int animalId) {
		animalDAO.delete(animalId);
	}

	public void edit(int animalId, String name) {
		animalDAO.edit(animalId, name);
	}

	public List<Animal> getAll() {
		return animalDAO.getAll();
	}

	public List<Animal> findByName(String name) {
		return animalDAO.findByName(name);
	}

}
