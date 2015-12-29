package com.bohdan.service;

import java.util.List;

import com.bohdan.model.Zooclub;

public interface ZooclubService {

	void insert(String name);

	void delete(int zooclubId);

	void edit(int zooclubId, String name);

	List<Zooclub> getAll();

	List<Zooclub> findByName(String name);
}
