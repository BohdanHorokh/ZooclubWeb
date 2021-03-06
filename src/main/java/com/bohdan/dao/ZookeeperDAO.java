package com.bohdan.dao;

import java.util.List;

import com.bohdan.model.Zookeeper;

public interface ZookeeperDAO {
	
	void insert(String firstName, String lastName, String[] animalId);

	void delete(int zookeeperId);

	void edit(int zookeeperId, String firstName, String lastName);

	List<Zookeeper> getAll();

	List<Zookeeper> findByFirstAndLastName(String firstName, String lastName);
	
	List<Zookeeper> findByFirstName(String firstName);
}
