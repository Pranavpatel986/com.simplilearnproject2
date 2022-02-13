package com.Simpli.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String email;
	
	@ManyToOne
	private ClassRoom classRoom;

	



	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}	
	public Student(String name, String email, ClassRoom classRoom) {
		super();
		this.name = name;
		this.email = email;
		this.classRoom = classRoom;
	}



	public ClassRoom getClassRoom() {
		return classRoom;
	}



	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", classRoom=" + classRoom + "]";
	}



	

	
	
}
