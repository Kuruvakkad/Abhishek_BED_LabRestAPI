package com.gl.project.College.controller;

import java.util.Set;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.gl.project.College.model.Student;
import com.gl.project.College.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
	
	
	private final StudentService studentService;
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return this.studentService.saveStudent(student);
	}
	
	@GetMapping
	public Set<Student>fetchAllStudents(){
		return this.studentService.fetchAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student fetchStudentById(@PathVariable("id") int id) {
		return this.studentService.fetchStudentById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudentById(@PathVariable("id") int id) {
		
		this.studentService.fetchStudentById(id);
		
	}
	
	/*@RequestMapping("/showNewCustomerForm")
	public String showNewCustomerForm(Model model) {
		Student student=new Student();
		model.addAttribute("Student", student);
		return "new_student";
	}
	
	

	
	
	@RequestMapping("/showFormForUpdate")
	public String formForUpdate(Model model,@RequestParam("id") int id) {
		Student student = studentService.fetchStudentById(id);
		model.addAttribute("Student",student);
		return "new_student";
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,Model model) {
		if(!firstName.isEmpty() || !lastName.isEmpty()) {
			List<Student> student = studentService.search(firstName, lastName);
			model.addAttribute("Student",student);
			return "index";
		}
		return "redirect:/students/list";
	}*/



}
