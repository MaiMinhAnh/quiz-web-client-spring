package com.quiz.model;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssignDTO {

	private int id_assign;
	
	private Date start;
	private Date end;
	private int score;
	
	private int id_test;
	
	private int id_user;
	private String username;
	private int id_result;
	
	
}
