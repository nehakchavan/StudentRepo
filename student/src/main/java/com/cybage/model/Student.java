package com.cybage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int roll_number;
	private String name;
	
	private String email;
	private String std;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int id, int roll_number, String name, String email, String std) {
		super();
		this.id = id;
		this.roll_number = roll_number;
		this.name = name;
		this.email = email;
		this.std = std;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoll_number() {
		return roll_number;
	}
	
	public void setRoll_number(int roll_number) {
		this.roll_number = roll_number;
	}
	
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
	
	public String getStd() {
		return std;
	}
	
	public void setStd(String std) {
		this.std = std;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", roll_number=" + roll_number + ", name=" + name + ", email=" + email + ", std="
				+ std + "]";
	}
}
