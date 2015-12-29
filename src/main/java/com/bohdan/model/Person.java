package com.bohdan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "Person.findByName", query = "select p from Person p where p.name like :name") })
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name = "id_person")
	private int id;
	private String name;
	private int age;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "person")
	private List<Animal> animals;
	@ManyToOne
	private Zooclub zooclub;

	public Person() {

	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person(String name, int age, Zooclub zooclub) {
		this.name = name;
		this.age = age;
		this.zooclub = zooclub;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public Zooclub getZooclub() {
		return zooclub;
	}

	public void setZooclub(Zooclub zooclub) {
		this.zooclub = zooclub;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
