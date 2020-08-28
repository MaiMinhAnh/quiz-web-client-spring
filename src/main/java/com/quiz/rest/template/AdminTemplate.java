package com.quiz.rest.template;





import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.quiz.model.UserDTO;


@Service
public class AdminTemplate {

	static final String URL_STRING="http://localhost:8080/quiz/user";
	
	
	//RestTemplate restTemplate = new RestTemplate();
	
	
	
	
//	
//	public List<UserDTO> getAllUser(String token){
//		List<UserDTO> userDTOs = new ArrayList<UserDTO>();		
//		RestTemplate restTemplate =  new RestTemplate();
//		
//		HttpHeaders headers = new HttpHeaders();
//		headers.set(HttpHeaders.AUTHORIZATION,token );
//		headers.setAccept(Arrays.asList(new MediaType[] {MediaType.APPLICATION_JSON}));
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		
//		HttpEntity<UserDTO[]> entity= new HttpEntity<UserDTO[]>(headers);
//		UserDTO[] u= restTemplate.exchange(URL_STRING+"/all", HttpMethod.GET, entity, UserDTO.class).getBody();
////		UserDTO[] result= restTemplate.getForObject(URL_STRING +"/all", UserDTO[].class);
////		for(UserDTO userDTO: u) {
////			userDTOs.add(userDTO);
////		}
//		
//		HttpHeaders headers = new HttpHeaders();
//		headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);
//		HttpEntity<?> entity = new HttpEntity<Object>(headers);
//		try {
//			return restTemplate.exchange(url, HttpMethod.GET, entity, classType).getBody();
//		} catch (HttpClientErrorException e) {
//			throw e;
//		}
//		
//		
//		userDTOs.add(u);
//		
//		
//		return userDTOs;
//	}	
//	
	
//	public UserDTO getUserByID(int id_user) {
//		RestTemplate restTemplate = new RestTemplate();
//		UserDTO userDTO = restTemplate.getForObject(URL_STRING+"/"+id_user, UserDTO.class);
//		
//		return userDTO;
//	}
	
	
//	public void creatUser(UserDTO userDTO) {
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.postForObject(URL_STRING+"/add", userDTO, UserDTO.class);
//	}
//	
//	public void update(UserDTO userDTO, int id_user) {
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.postForObject(URL_STRING + "/update/"+id_user, userDTO, UserDTO.class);
//	}
//	
//	public void delete(int id_user) {
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.getForObject(URL_STRING + "/delete/"+id_user, UserDTO.class);
//		
//	}
	
	public String login(UserDTO userDTO) {
		
		RestTemplate restTemplate = new RestTemplate();
		JSONObject resquest = new JSONObject();
		
		resquest.put("username", userDTO.getUsername());
		resquest.put("password", userDTO.getPassword());
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>(resquest.toString(),headers);
		ResponseEntity<String> loginResponse = restTemplate.exchange("http://localhost:8080/quiz/login", HttpMethod.POST, entity, String.class);
		
		System.out.println(loginResponse.getBody());
		return loginResponse.getBody();	
	}
	
	
	public UserDTO getByUsername(UserDTO userDTO) {
		
		RestTemplate restTemplate = new RestTemplate();
		JSONObject resquest = new JSONObject();
		
		resquest.put("username", userDTO.getUsername());
		resquest.put("password", userDTO.getPassword());
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>(resquest.toString(),headers);
		ResponseEntity<UserDTO> loginUser = restTemplate.exchange("http://localhost:8080/quiz/getUserByName", HttpMethod.POST, entity, UserDTO.class);
		
		return loginUser.getBody();	
	}
	
	
	
	
	
	
	
	
}
