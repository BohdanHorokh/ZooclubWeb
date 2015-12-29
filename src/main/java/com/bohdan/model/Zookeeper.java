package com.bohdan.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Zookeeper.findByFirstAndLastName", query = "select z from Zookeeper z where z.firstName = ?1 and z.lastName = ?2"), 
	@NamedQuery(name = "Zookeeper.findByFirstName", query = "select z from Zookeeper z where z.firstName like :firstName") })

public class Zookeeper {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Zookeepers_Animals", joinColumns = @JoinColumn(name = "zookeeper_id") , inverseJoinColumns = @JoinColumn(name = "animal_id") )
	private List<Animal> animals;

	public Zookeeper() {
	}

	
	public Zookeeper(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public int getId() {
		return id;
	}


	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Zookeeper [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", animals=" + animals
				+ "]";
	}

	
	
	
}
