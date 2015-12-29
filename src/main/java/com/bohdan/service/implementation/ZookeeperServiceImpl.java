package com.bohdan.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bohdan.dao.ZookeeperDAO;
import com.bohdan.model.Zookeeper;
import com.bohdan.service.ZookeeperService;

@Service
public class ZookeeperServiceImpl implements ZookeeperService {
	@Autowired
	private ZookeeperDAO zookeeperDAO;

	public void insert(String firstName, String lastName, String[] animalId) {
		zookeeperDAO.insert(firstName, lastName, animalId);
	}

	public void delete(int zookeeperId) {
		zookeeperDAO.delete(zookeeperId);
	}

	public void edit(int zookeeperId, String firstName, String lastName) {
		zookeeperDAO.edit(zookeeperId, firstName, lastName);
	}

	public List<Zookeeper> getAll() {
		return zookeeperDAO.getAll();
	}

	public List<Zookeeper> findByFirstAndLastName(String firstName, String lastName) {
		return zookeeperDAO.findByFirstAndLastName(firstName, lastName);
	}

	public List<Zookeeper> findByFirstName(String firstName) {
		return zookeeperDAO.findByFirstName(firstName);
	}

	

}
