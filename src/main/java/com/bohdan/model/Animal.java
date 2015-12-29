package com.bohdan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Animal.findByName", query = "select a from Animal a where a.name like :name") })
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String type;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Person person;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Zookeepers_Animals", joinColumns = @JoinColumn(name = "animal_id") , inverseJoinColumns = @JoinColumn(name = "zookeeper_id") )
	private List<Zookeeper> zookeepers;

	public Animal(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public Animal() {
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Zookeeper> getZookeepers() {
		return zookeepers;
	}

	public void setZookeepers(List<Zookeeper> zookeepers) {
		this.zookeepers = zookeepers;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + "]";
	}

}
