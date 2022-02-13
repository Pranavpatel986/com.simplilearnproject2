package com.Simpli.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	
	@ManyToMany
	private List<ClassRoom> classRooms;

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(String name, String email, List<ClassRoom> classRooms) {
		super();
		this.name = name;
		this.email = email;
		this.classRooms = classRooms;
	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ClassRoom> getClassRooms() {
		return classRooms;
	}

	public void setClassRooms(List<ClassRoom> classRooms) {
		this.classRooms = classRooms;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", email=" + email + ", classRooms=" + classRooms + "]";
	}
	
	
	
}
