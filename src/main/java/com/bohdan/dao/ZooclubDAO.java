package com.bohdan.dao;

import java.util.List;

import com.bohdan.model.Zooclub;

public interface ZooclubDAO {

	void insert(Zooclub zooclub);

	void delete(int zooclubId);

	void edit(int zooclubId, String name);

	List<Zooclub> getAll();

	List<Zooclub> findByName(String name);
}
