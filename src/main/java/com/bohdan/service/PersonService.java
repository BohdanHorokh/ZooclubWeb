package com.bohdan.service;

import java.util.List;

import com.bohdan.model.Person;

public interface PersonService {
	void insertPerson(String name, int age, int zooId);

	void deletePerson(int personId);

	void editPerson(int personId, String name, int age);

	List<Person> getAllPersons();

	Person findPersonByNameAndAge(String name, int age);
	
	List<Person> findPersonByName(String name);
}
