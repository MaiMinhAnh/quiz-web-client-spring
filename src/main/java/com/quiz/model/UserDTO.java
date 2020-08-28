package com.quiz.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private int id_user;
	private String username;
	private String password;
	private int role;
	private String role_name;
	private String token;
	
	private List<Integer> questionIDList;
	private List<Integer> testIDList;
	
	private List<Integer> assignIDList;

	public UserDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public UserDTO(int id_user, String username, String password, int role, String role_name, String token) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.password = password;
		this.role = role;
		this.role_name = role_name;
		this.token = token;
	}
	
	


	
	
	
}
