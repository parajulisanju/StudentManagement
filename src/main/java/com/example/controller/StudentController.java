package com.example.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public List<Student> getStudents() throws Exception {
		List<Student> myStudentList = studentService.getStudent();
		return myStudentList;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/map")
	public Map<Integer, Student> getStudentsMap() {
		Map<Integer, Student> myStudentMap = studentService.getStudentMap();
		return myStudentMap;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public Student addStudent(@RequestBody Student student) {
		Student savedStudent = studentService.saveStudent(student);
		return savedStudent;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete")
	public String deleteStudent(@RequestParam("id") Integer id) {
		studentService.deleteStudent(id);
		return "sucess";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/find-by-id")
	public Student findById(@RequestParam("id") Integer id) {
		Student foundStudent = studentService.findStudent(id);
		return foundStudent;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/find-by-age/{age}")
	public List<Student> findByAge(@PathVariable("age") Integer age) {
		List<Student> students = studentService.findByAge(age);
		return students;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/names")
	public List<String> getNames() {
		List<String> nameList = studentService.getNames();
		return nameList;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/set/names")
	public Set<String> getUniqueNames() {
		Set<String> uniqueNameList = studentService.getUniqueNames();
		return uniqueNameList;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/names-native")
	public List<String> getNamesNative() {
		List<String> nameList = studentService.getNamesNative();
		return nameList;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/find-by-age-jpql/{age}")
	public List<Student> findByAgeJpql(@PathVariable("age") Integer age) {
		List<Student> students = studentService.findByAgeJpql(age);
		return students;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/largest-student")
	public Student getLargestStudent() {
		return studentService.compareStudents();
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public Student updateFindByAge(@RequestBody Student student) {
		Student student1 = studentService.saveStudent(student);
		return student1;
	}

}