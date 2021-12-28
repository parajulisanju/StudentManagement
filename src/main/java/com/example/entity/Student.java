package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Comparable<Student> {
	// no-argument constructor

	// parameterized constructor
//	

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private int age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Student stud) {
		if (this.getAge() > stud.getAge())
			return 1;
		else if (this.getAge() < stud.getAge())
			return -1;
		else
			return 0;
	}

}
