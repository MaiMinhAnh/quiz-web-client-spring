package com.quiz.rest.template;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.quiz.model.QuestionDTO;

@Service
public class QuestionTemplate {

	static final String URL_STRING="http://localhost:8080/question/";
	
	//lay het cau hoi
	public List<QuestionDTO> getAllQuestion(){
		RestTemplate restTemplate = new RestTemplate();
		List<QuestionDTO> questionDTOs = new ArrayList<QuestionDTO>();
		QuestionDTO[] result=  restTemplate.getForObject(URL_STRING +"all", QuestionDTO[].class);
		for(QuestionDTO q:result) {
			questionDTOs.add(q);
		}
		 return questionDTOs;
	}
	
	//lay 1 cau hoi
	public QuestionDTO getQuestionByID(int id_ques) {
		RestTemplate restTemplate = new RestTemplate();
		QuestionDTO questionDTO = restTemplate.getForObject(URL_STRING + id_ques , QuestionDTO.class);
		return questionDTO;
	}
	
	//xoa cau hoi
	public void deleteQuestion(int id_ques) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject(URL_STRING +"delete/"+id_ques, QuestionDTO.class);
	}
	
	//update
	public void updateQuestion(QuestionDTO questionDTO, int id_ques) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(URL_STRING + "update/"+id_ques, questionDTO, QuestionDTO.class);
	}
	
	//add
	public void createQuestion(QuestionDTO questionDTO) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(URL_STRING +"/add", questionDTO, QuestionDTO.class);
	}
}
