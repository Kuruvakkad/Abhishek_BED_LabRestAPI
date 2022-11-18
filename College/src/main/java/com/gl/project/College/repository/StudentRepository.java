package com.gl.project.College.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.project.College.model.Student;
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public List<Student> findByFirstNameContainsAndLastNameContainsAllIgnoreCase(String firstName, String lastName);

}
