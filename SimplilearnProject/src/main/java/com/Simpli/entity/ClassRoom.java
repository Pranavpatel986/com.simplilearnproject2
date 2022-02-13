package com.Simpli.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class ClassRoom {
	
	@Id
	private int id;
	private String classname;
	
	private int capacity;


//	@ManyToMany
//	private List<Teacher> teachers;

	
	
	
	public ClassRoom() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	public ClassRoom(int id, String classname, int capacity) {
		super();
		this.id = id;
		this.classname = classname;
		this.capacity = capacity;

	}



	public int getCapacity() {
		return capacity;
	}



	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}




	@Override
	public String toString() {
		return "ClassRoom [id=" + id + ", classname=" + classname + ", capacity=" + capacity + "]";
	}




	


	

   
}
