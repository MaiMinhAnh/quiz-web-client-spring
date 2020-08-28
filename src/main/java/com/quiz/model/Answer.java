package com.quiz.model;

public class Answer {

	private int id_answer;
	private int answer;
	private int id_question;
	
	
	public Answer(int id_answer, int answer) {
		super();
		this.id_answer = id_answer;
		this.answer = answer;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_answer() {
		return id_answer;
	}
	public void setId_answer(int id_answer) {
		this.id_answer = id_answer;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public int getId_question() {
		return id_question;
	}
	public void setId_question(int id_question) {
		this.id_question = id_question;
	}
	
	
	
}
