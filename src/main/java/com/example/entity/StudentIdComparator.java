package com.example.entity;

import java.util.Comparator;

public class StudentIdComparator implements Comparator<Student> {

	@Override
	public int compare(Student stud1, Student stud2) {
		return stud1.getId().compareTo(stud2.getId());
	}

}

