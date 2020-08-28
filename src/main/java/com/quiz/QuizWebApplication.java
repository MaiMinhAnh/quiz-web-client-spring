package com.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication(scanBasePackages = { "com.quiz" })
@EnableJpaRepositories("com.example")
public class QuizWebApplication {

	
	//static final String URL_STRING = "http://localhost:8080/user/getall";
	public static void main(String[] args) {
		SpringApplication.run(QuizWebApplication.class, args);
		
		

	}

}
