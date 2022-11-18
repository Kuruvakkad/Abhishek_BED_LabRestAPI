package com.gl.project.College.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.gl.project.College.model.Student;
import com.gl.project.College.repository.StudentRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	public Set<Student> fetchAllStudents(){
		return new HashSet<>(this.studentRepository.findAll());
	}
	
	public Student saveStudent(Student student) {
		return this.studentRepository.save(student);
		
	}
	
	public void deleteStudentById(int id) {
		this.studentRepository.deleteById(id);
	}
		
	public Student fetchStudentById(int id) {
		return this.studentRepository.findById(id).orElseThrow();
	}

}
