package com.quiz.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.api_exchange.ApiExchangeService;
import com.quiz.model.AssignDTO;
import com.quiz.model.QuestionDTO;
import com.quiz.model.TestDTO;
import com.quiz.model.UserDTO;
import com.quiz.rest.template.AdminTemplate;



@Controller
public class MainController {

	public static UserDTO userResponse;
	public static UserDTO currentUser;
	public static TestDTO test;
	public static AssignDTO assign= new AssignDTO();
	public static List<QuestionDTO> questionDTOs = new ArrayList<QuestionDTO>();

	public static String errorMessage;
	public static String url = "";
	public static final String URL_PREFIX = "http://localhost:8080/quiz/";

	public static String token = "";
	
	public static Map<Integer, Integer> userChoices;
	

	@Autowired
	ApiExchangeService apiExchangeService;

	@Autowired
	AdminTemplate adminTemplate;

	// login
	@GetMapping(value = "login")
	public String getLogin() {
		return "login";
	}



	@PostMapping(value = "/login")
	public String login(@ModelAttribute("login") UserDTO userDTO, HttpServletRequest request) {
		token = adminTemplate.login(userDTO);
		currentUser = adminTemplate.getByUsername(userDTO);

		switch (currentUser.getRole()) {
		case 1:
			return "redirect:/all";
		case 2:
			return "redirect:/question/all";
		case 3:
			return "student-homepage";
		default:
			return "admin/home";
		}
		

	}

	// ----------------------------------------ADMIN------------------------------------------------

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getAllUser(HttpServletRequest request) {

		url = URL_PREFIX + "user/all";
		UserDTO[] userDTOs = apiExchangeService.get(url, UserDTO[].class, token);

		List<UserDTO> userList = new ArrayList<UserDTO>();
		for (UserDTO userDTO : userDTOs) {
			if (userDTO.getRole() != 1) {
				userList.add(userDTO);
			}
		}
		request.setAttribute("users", userList);
		return "admin/list_user";
	}

	// delete
	@GetMapping(value = "/delete/{id_user}")
	public String deleteAccount(@PathVariable("id_user") Integer id_user) {
		url = URL_PREFIX + "user/delete/" + id_user;
		//apiExchangeService.delete(url, token);
		apiExchangeService.get(url, UserDTO.class, token);
		return "redirect:/all";
	}

	// edit
	@GetMapping(value = "/edit/{id_user}")
	public String getUserByID(HttpServletRequest request, @PathVariable("id_user") Integer id_user) {
		url = URL_PREFIX + "user/" + id_user;
		UserDTO userDTO = apiExchangeService.get(url, UserDTO.class, token);
		request.setAttribute("update_user", userDTO);
		return "admin/detail_user";
	}

	@PostMapping(value = "/edit/{id_user}")
	public String updateUser(@ModelAttribute("update_user") UserDTO userDTO, 
			@PathVariable("id_user") Integer id_user) {
		url = URL_PREFIX + "user/update/"+id_user;
		apiExchangeService.post(url, userDTO, UserDTO.class, token);
		return "redirect:/all";
	}
	
	//add-new
	@GetMapping(value = "/create")
	public String createUserView(Model model) {
		model.addAttribute("user", new UserDTO());
		return "admin/adduser";
	}
	
	@PostMapping(value = "/create")
	public String createUser(HttpServletRequest request, @ModelAttribute("user") UserDTO userDTO) {
		url = URL_PREFIX + "user/add";
		apiExchangeService.post(url, userDTO, UserDTO.class, token);
		return "redirect:/all";
	}
	

	//--------------------------------------TEACHER-----------------------------------------------
	
	public static final String URL_QUESTION = "http://localhost:8080/quiz/question/";
	

	//tat ca cau hoi
	@RequestMapping(value = "/question/all", method = RequestMethod.GET)
	public String getAllQuestion(HttpServletRequest request) {
		url = URL_QUESTION + "all";
		QuestionDTO[] questions = apiExchangeService.get(url, QuestionDTO[].class, token);
		List<QuestionDTO> questionDTOs = new ArrayList<QuestionDTO>();
		for(QuestionDTO q:questions) {
			questionDTOs.add(q);
		}
		
		request.setAttribute("questions", questionDTOs);
		return "question/list_question";
	}

	//xoa
	@GetMapping(value = "/delete/ques/{id_question}")
	public String deleteQuestion(@PathVariable("id_question") Integer id_question) {
		url = URL_PREFIX + "question/delete/" + id_question;
		//apiExchangeService.delete(url, token);
		apiExchangeService.get(url, QuestionDTO.class, token);
		return "redirect:/question/all";
	}
	
	//lay 1 cau hoi de sua

	@GetMapping(value = "/question/{id_ques}")
	public String editQuestion(HttpServletRequest request, @PathVariable("id_ques") Integer id_ques) {
		url = URL_QUESTION + id_ques;
		QuestionDTO questionDTO = apiExchangeService.get(url, QuestionDTO.class, token);
		request.setAttribute("update_ques", questionDTO);
		return "question/detail_question";
	}

	@PostMapping(value = "/question/{id_ques}")
	public String updateQuestion(@ModelAttribute("update_ques") QuestionDTO questionDTO, 
			@PathVariable("id_ques") Integer id_ques) {
		url = URL_QUESTION + "update/"+id_ques;
		apiExchangeService.post(url, questionDTO, QuestionDTO.class, token);
		return "redirect:/question/all";
	}
	
//	//get trang them cau hoi

	@GetMapping(value = "/question/add")
	public String createQuestion(Model model) {
		model.addAttribute("question", new QuestionDTO());
		return "question/addquestion";
	}

	@PostMapping(value = "/question/add")
	public String createQuestion(HttpServletRequest request, @ModelAttribute("question") QuestionDTO questionDTO) {
		questionDTO.setId_user(currentUser.getId_user());
		url = URL_QUESTION + "add";
		apiExchangeService.post(url, questionDTO, QuestionDTO.class, token);
		return "redirect:/question/all";
	}
	
	
	//xem danh sach cac test
	@GetMapping(value = "/test-list")
	public String listTest(HttpServletRequest request) {
		url = URL_PREFIX +"test/all";
		TestDTO[] testList = apiExchangeService.get(url, TestDTO[].class, token);
		List<TestDTO> tests = new ArrayList<TestDTO>();
		for(TestDTO t: testList) {
			tests.add(t);
		}
		//tests.ge
		request.setAttribute("tests", tests);
		return "list-test";
		
	}
	//xem danh sach cau hoi trong test
	@GetMapping(value = "/list_question/{id_test}")
	public String listQuestion(HttpServletRequest request, @PathVariable("id_test") Integer id_test) {
		url = URL_PREFIX+"test/"+id_test;
		TestDTO testDTO= apiExchangeService.get(url, TestDTO.class, token);
		List<QuestionDTO> listQuestion = new ArrayList<QuestionDTO>();
		for(int qID: testDTO.getQuestionIDList()) {
			QuestionDTO questionDTO = apiExchangeService.get(URL_PREFIX+"question/"+qID, QuestionDTO.class, token);
			listQuestion.add(questionDTO);
			
		}
		request.setAttribute("list_question", listQuestion);
		return "list-question-test";
	}
	//xem bai lam cua test
	@GetMapping(value = "/assign/{id_test}")
	public String assign(HttpServletRequest request, @PathVariable("id_test") Integer id_test) {
		url = URL_PREFIX+"assign/"+id_test;
		AssignDTO a = apiExchangeService.get(url, AssignDTO.class, token);
		request.setAttribute("assign_test", a);
		return "assign-test";
	}
	
	//----------------------------------------STUDENT----------------------------------------------------
	@GetMapping(value = "test/add")
	public String takeQuiz(HttpServletRequest request, @ModelAttribute("new_quiz") TestDTO testDTO) {
		TestDTO[] testList = apiExchangeService.get(URL_PREFIX+"test/all", TestDTO[].class, token);
		List<TestDTO> tests = new ArrayList<TestDTO>();
		for(TestDTO t: testList) {
			tests.add(t);
		}
		TestDTO t = tests.get(tests.size()-1);
		
		
		url = URL_PREFIX + "test/add";
		testDTO.setName("Quiz"+(t.getId_test()+1));
		testDTO.setId_user(currentUser.getId_user());
		apiExchangeService.post(url, testDTO, TestDTO.class, token);
		
		  test= apiExchangeService.get(URL_PREFIX+"test/name/" + testDTO.getName(), TestDTO.class, token);
		//List<QuestionDTO> questionDTOs = new ArrayList<QuestionDTO>();
		for(int qID : test.getQuestionIDList()) {
			QuestionDTO q = apiExchangeService.get(URL_PREFIX + "question/"+qID, QuestionDTO.class, token);
			questionDTOs.add(q);
		}
		
		assign.setStart(getCurrentTime());
		assign.setId_user(currentUser.getId_user());
		assign.setId_test(test.getId_test());
		
		request.setAttribute("quiz", test);
		request.setAttribute("list_ques", questionDTOs);
		
		return "quiz";
	}
	
	public static Date getCurrentTime() {
		return new Date();
	}
	
	@PostMapping(value = "quiz/submit")
	public String assign(HttpServletRequest request, @RequestParam Map<String, String> requestMapper) {
		userChoices = new HashMap<Integer, Integer>();
		Integer choices;
		for(QuestionDTO q: questionDTOs) {
			if(requestMapper.get(q.getId_question()+"")==null) {
				choices =0;
			}else {
				choices=Integer.parseInt(requestMapper.get(q.getId_question()+""));
			}
			userChoices.put(q.getId_question(), choices);
		}
		
		assign.setEnd(getCurrentTime());
		return "redirect:/quiz/result";
	}
	
	
	@GetMapping(value = "quiz/result")
	public String getResult(HttpServletRequest request) {

		
		int score=0;

		int choice;
		for (QuestionDTO q  : questionDTOs) {
			choice = userChoices.get(q.getId_question());
			// Compare the answer of the question with its correct answer
			if (choice == q.getAnswer()) {
				score+=2;
			}
		}
		assign.setScore(score);
		url= URL_PREFIX+"assign/create";
		apiExchangeService.put(url, assign, token);
		//apiExchangeService.post(url, assign, AssignDTO.class, token);
		request.setAttribute("user", currentUser);
		request.setAttribute("result", assign);
		return "result";
	}
	
	@GetMapping(value = "/assign/")
	public String getAllAssign(HttpServletRequest request) {
		request.setAttribute("current_user", currentUser);
		
		url = URL_PREFIX +"assign/user/"+currentUser.getUsername();
		AssignDTO[] assignDTOs = apiExchangeService.get(url, AssignDTO[].class, token);
		List<AssignDTO> assignList= new ArrayList<AssignDTO>();
		for(AssignDTO a: assignDTOs) {
			assignList.add(a);
		}
		request.setAttribute("list_assign", assignList);
		return "list-assign";
		
	}
	

	
}
