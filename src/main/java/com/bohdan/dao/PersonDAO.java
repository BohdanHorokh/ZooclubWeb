package com.bohdan.dao;

import java.util.List;

import com.bohdan.model.Person;

public interface PersonDAO {
	
	void insertPerson(String name, int age, int zooId);
	
	List<Person> getAllPersons();
	
	Person findPersonByNameAndAge(String name, int age);
	
	List<Person> findPersonByName(String name);
	
	void deletePerson(int personId);
	
	void editPerson(int personId, String name, int age);
}
