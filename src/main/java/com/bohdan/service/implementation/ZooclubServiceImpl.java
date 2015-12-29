package com.bohdan.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bohdan.dao.ZooclubDAO;
import com.bohdan.model.Zooclub;
import com.bohdan.service.ZooclubService;

@Service
public class ZooclubServiceImpl implements ZooclubService{
	@Autowired
	private ZooclubDAO zooclubDAO;

	public void insert(String name) {
		Zooclub zooclub = new Zooclub(name);
		zooclubDAO.insert(zooclub);
	}

	public void delete(int zooclubId) {
		zooclubDAO.delete(zooclubId);
	}

	public void edit(int zooclubId, String name) {
		zooclubDAO.edit(zooclubId, name);
	}

	public List<Zooclub> getAll() {
		return zooclubDAO.getAll();
	}

	public List<Zooclub> findByName(String name) {
		return zooclubDAO.findByName(name);
	}
	
	
}
