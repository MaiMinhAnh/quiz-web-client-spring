package com.quiz.model;



public class QuestionDTO {

	private int id_question;
	private String question;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	
	private int id_user;
	private String username;
	private int answer;
	
	
	//khong can quan tam cau naof thuoc test nao
	//private int id_test_ques;
	
	
	//private List<Integer> testIDList;
	
	public QuestionDTO(int id_question, String question, String ans1, String ans2, String ans3, String ans4) {
		super();
		this.id_question = id_question;
		this.question = question;
		this.ans1 = ans1;
		this.ans2 = ans2;
		this.ans3 = ans3;
		this.ans4 = ans4;
	}
	public QuestionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_question() {
		return id_question;
	}
	public void setId_question(int id_question) {
		this.id_question = id_question;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAns1() {
		return ans1;
	}
	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}
	public String getAns2() {
		return ans2;
	}
	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}
	public String getAns3() {
		return ans3;
	}
	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}
	public String getAns4() {
		return ans4;
	}
	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
//	public int getId_test_ques() {
//		return id_test_ques;
//	}
//	public void setId_test_ques(int id_test_ques) {
//		this.id_test_ques = id_test_ques;
//	}

	
	
}
