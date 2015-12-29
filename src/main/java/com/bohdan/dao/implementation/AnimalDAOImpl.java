package com.bohdan.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bohdan.dao.AnimalDAO;
import com.bohdan.model.Animal;
import com.bohdan.model.Person;

@Repository
public class AnimalDAOImpl implements AnimalDAO {

	@PersistenceContext(unitName = "Main")
	private EntityManager em;

	@Transactional
	public void insert(String name, String type, int personId) {
		Person person = em.find(Person.class, personId);
		Animal animal = new Animal();
		animal.setName(name);
		animal.setType(type);
		animal.setPerson(person);
		em.persist(animal);
	}

	@Transactional
	public void delete(int animalId) {
		Animal animal = em.find(Animal.class, animalId);
		em.remove(animal);
	}

	@Transactional
	public void edit(int animalId, String name) {
		Animal animal = em.find(Animal.class, animalId);
		animal.setName(name);
		em.merge(animal);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Animal> getAll() {
		return em.createQuery("from Animal").getResultList();
	}

	@Transactional
	public List<Animal> findByName(String name) {
		return em.createNamedQuery("Animal.findByName").setParameter("name", name).getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
