package com.bohdan.dao;

import java.util.List;

import com.bohdan.model.Animal;

public interface AnimalDAO {
	void insert(String name, String type, int personId);

	void delete(int animalId);

	void edit(int animalId, String name);

	List<Animal> getAll();

	List<Animal> findByName(String name);
}
