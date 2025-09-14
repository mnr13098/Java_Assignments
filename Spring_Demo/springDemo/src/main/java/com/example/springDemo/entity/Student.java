package com.example.springDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student extends Person {

	public Student() {
		super();
	}
	
	private int id;

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public Student(String email, String name, String address, int id) {
        super();
        setEmail(email);
        setName(name);
        setAddress(address);
        this.id = id;
    }
	
	
	@Override
    public String toString() {
        return "Student [email=" + getEmail() + ", name=" + getName() + ", address=" + getAddress()
                + ", id=" + id + "]";
    }
	
	
	
	
}
