package com.gl.project.College.util;



import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gl.project.College.model.Role;
import com.gl.project.College.model.Student;
import com.gl.project.College.model.User;
import com.gl.project.College.repository.StudentRepository;
import com.gl.project.College.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootstrapAppData {
	
	private final StudentRepository studentRepository;
	private final UserRepository userRepository;
	private final PasswordEncoder passworEncoder;
	
	@EventListener(ApplicationReadyEvent.class)
	public void insertStudents(ApplicationReadyEvent event) {
		
		Student ramesh=new Student();
		ramesh.setFirstName("Ramesh");
		ramesh.setLastName("Babu");
		ramesh.setCourse("IIT");
		ramesh.setCountry("india");
		this.studentRepository.save(ramesh);
		
		Student amesh=new Student();
		ramesh.setFirstName("Amesh");
		ramesh.setLastName("Sabu");
		ramesh.setCourse("IIM");
		ramesh.setCountry("india");
		this.studentRepository.save(amesh);
		
		User vinay=new User();
		vinay.setUsername("vinay");
		vinay.setPassword(this.passworEncoder.encode("user"));
		vinay.setEmailAddress("vinay@gmail.com");
	
		
		Role kiranRole = new Role();
		kiranRole.setRoleName("USER");
		
		Role vinayRole= new Role();
		vinayRole.setRoleName("ADMIN");
		
		
		vinayRole.setUser(vinay);
		vinay.addRole(vinayRole);
		
		
		
		User kiran=new User();
		kiran.setUsername("kiran");
		kiran.setPassword(this.passworEncoder.encode("user"));
		kiran.setEmailAddress("kiran@gmail.com");
		kiran.addRole(kiranRole);
		
		
		
		this.userRepository.save(kiran);
		this.userRepository.save(vinay);

		
		
	}

}
