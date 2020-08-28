package com.quiz.model;

import java.util.List;

public class RoleDTO {

	private int id_role;
	private String name;
	private List<UserDTO> userDTOs;
	public RoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleDTO(int id_role, String name, List<UserDTO> userDTOs) {
		super();
		this.id_role = id_role;
		this.name = name;
		//this.userDTOs = userDTOs;
	}
	public int getId_role() {
		return id_role;
	}
	public void setId_role(int id_role) {
		this.id_role = id_role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UserDTO> getUserDTOs() {
		return userDTOs;
	}
	public void setUserDTOs(List<UserDTO> userDTOs) {
		this.userDTOs = userDTOs;
	}
	
	
	
	
}
