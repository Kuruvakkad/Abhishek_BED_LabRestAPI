package com.gl.project.College.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryptor {
	
	public static void main(String[]args) {
		BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
		String plainText="user";
		String encodedPassword=passwordEncoder.encode(plainText);
		System.out.println(encodedPassword);
	}

}
