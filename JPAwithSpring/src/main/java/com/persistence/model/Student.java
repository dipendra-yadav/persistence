package com.persistence.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	private long id;

	private String name;

	//const
	public Student() {
	}

	public Student(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// acessors n mutators
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}