package com.raymundo.gonet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class DemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String password = "raytest";
//		String encodedPassword = passwordEncoder.encode(password);
//
//		System.out.println("");
//		System.out.println("Password is         : " + password);
//		System.out.println("Encoded Password is : " + encodedPassword);
//		System.out.println("");
//		
//		BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
//		String password2 = "rayher";
//		String encodedPassword2 = passwordEncoder2.encode(password2);
//
//		System.out.println("");
//		System.out.println("Password is         : " + password2);
//		System.out.println("Encoded Password is : " + encodedPassword2);
//		System.out.println("");
//
//		
//		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
//		System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
//		
//		boolean isPasswordMatch2 = passwordEncoder2.matches(password2, encodedPassword2);
//		System.out.println("Password2 : " + password2 + "   isPasswordMatch2    : " + isPasswordMatch2);
		
	}
	

	  @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
	  

}
