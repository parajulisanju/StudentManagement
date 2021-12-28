package com.example.entity;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student stud1, Student stud2) {
		return stud1.getName().compareTo(stud2.getName());
	}

}
