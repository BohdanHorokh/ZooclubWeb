package com.bohdan.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bohdan.dao.PersonDAO;
import com.bohdan.model.Person;
import com.bohdan.model.Zooclub;

@Repository
public class PersonDAOImpl implements PersonDAO {
	@PersistenceContext(unitName = "Main")
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void insertPerson(String name, int age, int zooId) {
		Zooclub zooclub = em.find(Zooclub.class, zooId);
		Person person = new Person(name, age, zooclub);
		em.persist(person);
	}

	@Transactional
	public void deletePerson(int personId) {
		Person person = em.find(Person.class, personId);
		em.remove(person);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Person> getAllPersons() {
		return em.createQuery("from Person").getResultList();
	}

	@Transactional
	public Person findPersonByNameAndAge(String name, int age) {
		Person person = (Person) em.createQuery("select p from Person p where p.name= :name and p.age= :age")
				.setParameter("name", name).setParameter("age", age).getResultList();
		return person;
	}

	@Transactional
	public void editPerson(int personId, String name, int age) {
		Person person = em.find(Person.class, personId);
		person.setName(name);
		person.setAge(age);
		em.merge(person);
	}

	@Transactional
	public List<Person> findPersonByName(String name) {
		return em.createNamedQuery("Person.findByName").setParameter("name", name).getResultList();
	}

}
