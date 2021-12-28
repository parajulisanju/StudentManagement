package com.example.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.entity.StudentNameComparator;
import com.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getStudent() {
		List<Student> myStudentList = this.studentRepository.findAll();
		return myStudentList;
	}

	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
//		int a = 9;
//		int d = 10;
//		int c1 = a + d;

		Student savedStudent = studentRepository.save(student);
		return savedStudent;

	}

	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);

	}

	public Student findStudent(Integer id) {
		try {
			Student student = studentRepository.findById(id).get();
			return student;
		} catch (NoSuchElementException ex) {
			return null;

		}
	}

	public List<Student> findByAge(Integer age) {
		List<Student> students = studentRepository.findAll();
//		List<Student> newList = new ArrayList<>();

//		Using for loop
//		for (int i = 0; i < students.size(); i++) {
//			Student eachStudent = students.get(i);
//			if (eachStudent.getAge() > age) {
//				newList.add(eachStudent);
//			}
//		}

//		Using Lambda expression
//		students.forEach(eachStudent -> {
//			if (eachStudent.getAge() > age) {
//				newList.add(eachStudent);
//			}
//		});

//		Using Lambda expression with filter
		List<Student> newList = students.stream().filter(eachStudent -> eachStudent.getAge() > age)
				.collect(Collectors.toList());

		return newList;

	}

	public List<String> getNames() {
		// TODO Auto-generated method stub

		List<Student> students = studentRepository.findAll();
		List<String> newstr = new ArrayList<>();
		for (int i = 0; i < students.size(); i++) {
			String eachName = students.get(i).getName();
			newstr.add(eachName);

		}
		return newstr;
	}

	public List<String> getNamesNative() {
		List<String> names = studentRepository.getAllNames();
		return names;
	}

	public List<Student> findByAgeJpql(Integer age) {
		List<Student> students = studentRepository.findAllAgeGraterThan(age);
		return students;
	}

	public Map<Integer, Student> getStudentMap() {
		List<Student> students = studentRepository.findAll();
		Map<Integer, Student> map = new HashMap<>();
		for (int i = 0; i < students.size(); i++) {
			Student eachStudent = students.get(i);
			map.put(eachStudent.getId(), eachStudent);
		}

		return map;
	}

	public Set<String> getUniqueNames() {
		List<Student> students = studentRepository.findAll();

//		Using traditional for loop
//		Set<String> set = new HashSet<String>();
//		for (int i = 0; i < students.size(); i++) {
//			Student eachStudent = students.get(i);
//			set.add(eachStudent.getName());
//		}

//		Using lambda-expression

		Set<String> studentSet = students.stream().map(eachStudent -> eachStudent.getName())
				.collect(Collectors.toSet());

		return studentSet;
	}

	public Set<Integer> getUniqueIds() {
		List<Student> students = studentRepository.findAll();

		Set<Integer> studentId = students.stream().map(eachStudent -> eachStudent.getId()).collect(Collectors.toSet());

		return studentId;

	}

	public Student compareStudents() {
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("First student");
		student1.setAge(20);

		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Second student");
		student2.setAge(40);

		int result1 = student1.compareTo(student2);
		System.out.println(result1);

		int result2 = student2.compareTo(student1);
		System.out.println(result2);

		List<Student> students = new ArrayList<>();
		students.add(student1);
		students.add(student2);
		Collections.sort(students);

		return null;
	}

	public Student compareStudents2() {
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("First student");
		student1.setAge(20);

		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Second student");
		student2.setAge(40);

		StudentNameComparator comparator = new StudentNameComparator();

		int result1 = comparator.compare(student1, student2);
		System.out.println(result1);

		int result2 = comparator.compare(student2, student1);
		System.out.println(result2);

		return null;
	}
}