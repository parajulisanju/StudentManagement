package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
//	This method is by default present in this repository, so it is not needed
//	public Student save(Student student);

	@Query(value = "select name from student", nativeQuery = true)
	List<String> getAllNames();

	@Query(value = "SELECT s FROM Student s WHERE s.age >= :age")
	List<Student> findAllAgeGraterThan(@Param("age") int age);

	
}
