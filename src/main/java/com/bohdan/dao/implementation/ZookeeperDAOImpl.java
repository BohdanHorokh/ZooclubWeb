package com.bohdan.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bohdan.dao.ZookeeperDAO;
import com.bohdan.model.Animal;
import com.bohdan.model.Zookeeper;

@Repository
public class ZookeeperDAOImpl implements ZookeeperDAO {
	@PersistenceContext(unitName = "Main")
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public void insert(String firstName, String lastName, String[] animalId) {
		List<Animal> animals = new ArrayList<Animal>();
		Zookeeper zookeeper = new Zookeeper(firstName, lastName);
		for (String s: animalId) {
			try {
				int id = Integer.parseInt(s);
				Animal animal = em.find(Animal.class, id);
				animals.add(animal);
			} catch (NumberFormatException exception) {
				System.out.println("not a number");
			}
			
			
			
		}
		zookeeper.setAnimals(animals);
		em.persist(zookeeper);
	}

	@Transactional
	public void delete(int zookeeperId) {
		Zookeeper zookeeper = em.find(Zookeeper.class, zookeeperId);
		em.remove(zookeeper);
	}


	@Transactional
	public void edit(int zookeeperId, String firstName, String lastName) {
		Zookeeper zookeeper = em.find(Zookeeper.class, zookeeperId); 
		zookeeper.setFirstName(firstName);
		zookeeper.setLastName(lastName);
		em.merge(zookeeper);
	}

	
	@Transactional
	public List<Zookeeper> getAll() {
		return em.createQuery("from Zookeeper").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Zookeeper> findByFirstAndLastName(String firstName, String lastName) {
		return em.createNamedQuery("Zookeeper.findByFirstAndLastName").setParameter("firstName", firstName).setParameter("lastName", lastName).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Zookeeper> findByFirstName(String firstName) {
		return em.createNamedQuery("Zookeeper.findByFirstName").setParameter("firstName", firstName).getResultList();
	}
	
	
}
