package com.bohdan.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bohdan.dao.ZooclubDAO;
import com.bohdan.model.Person;
import com.bohdan.model.Zooclub;

@Repository
public class ZooclubDAOImpl implements ZooclubDAO {
	@PersistenceContext(unitName = "Main")
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void insert(Zooclub zooclub) {
		em.persist(zooclub);
	}

	@Transactional
	public void delete(int zooclubId) {
		Zooclub zooclub = em.find(Zooclub.class, zooclubId);
		em.remove(zooclub);
	}

	@Transactional
	public void edit(int zooclubId, String name) {
		Zooclub zooclub = em.find(Zooclub.class, zooclubId);
		zooclub.setName(name);
		em.merge(zooclub);
	}

	@Transactional
	public List<Zooclub> getAll() {
		return em.createQuery("From Zooclub").getResultList();
	}

	@Transactional
	public List<Zooclub> findByName(String name) {
		return em.createNamedQuery("Zooclub.findByName").setParameter("name", name).getResultList();
	}

}
