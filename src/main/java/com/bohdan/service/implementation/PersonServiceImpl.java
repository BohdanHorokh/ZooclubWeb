package com.bohdan.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bohdan.dao.PersonDAO;
import com.bohdan.model.Person;
import com.bohdan.model.Zooclub;
import com.bohdan.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;

	public void deletePerson(int personId) {
		personDAO.deletePerson(personId);
	}

	public void insertPerson(String name, int age, int zooId) {
		personDAO.insertPerson(name, age, zooId);
	}

	public void editPerson(int personId, String name, int age) {
		personDAO.editPerson(personId, name, age);
	}

	public List<Person> findPersonByName(String name) {
		return personDAO.findPersonByName(name);
	}

	public List<Person> getAllPersons() {
		return personDAO.getAllPersons();
	}

	public Person findPersonByNameAndAge(String name, int age) {
		return personDAO.findPersonByNameAndAge(name, age);
	}

}
