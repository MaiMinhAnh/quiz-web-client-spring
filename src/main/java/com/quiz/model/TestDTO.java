package com.quiz.model;

import java.util.List;

public class TestDTO {

	private int id_test;
	private String name;
	private List<Integer> questionIDList;
	private int id_user;
	
	private int id_assign;
	
	public TestDTO( int id_test, String name) {
		super();
		this.id_test = id_test;
		this.name = name;
	}
	public TestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getQuestionIDList() {
		return questionIDList;
	}
	public void setQuestionIDList(List<Integer> questionIDList) {
		this.questionIDList = questionIDList;
	}
	public int getId_test() {
		return id_test;
	}
	public void setId_test(int id_test) {
		this.id_test = id_test;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_assign() {
		return id_assign;
	}
	public void setId_assign(int id_assign) {
		this.id_assign = id_assign;
	}
	
	
	
	
}
