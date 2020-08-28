//package com.quiz.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//
//import com.quiz.model.UserDTO;
//import com.quiz.rest.template.AdminTemplate;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//
//	@Autowired
//	AdminTemplate adminTemplate;
//	
//	public static List<UserDTO> userDtos = new ArrayList<UserDTO>();
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home() {
//		return "admin/home";
//	}
//	
//
////	@RequestMapping(value = "/all", method = RequestMethod.GET)
////	public String getAllUser(HttpServletRequest request,  Model model) {
////		//String headers="eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1OTc5MTA3NzgsInVzZXJuYW1lIjoiYW5oIn0.fL8-dvVayyToYhV495_V_R8OFfW5M6rX-STrPC7wA1s";
////		List<UserDTO> userDTOs = adminTemplate.getAllUser();
////		request.setAttribute("users", userDTOs);
////		return "admin/list_user";
////	}
//	
//	
//	//lay ra chi tiet de update
//	@RequestMapping(value = "/edit/{id_user}", method = RequestMethod.GET)
//	public String getUserByID(HttpServletRequest request, @PathVariable("id_user") Integer id_user) {
//		UserDTO userDTO = adminTemplate.getUserByID(id_user);
//		request.setAttribute("update_user", userDTO);
//		return "admin/detail_user";
//	}
//	
//	
//	@RequestMapping(value = "/edit/{id_user}", method = RequestMethod.POST)
//	public String updateUser(@ModelAttribute("update_user") UserDTO userDTO, 
//			@PathVariable("id_user") Integer id_user) {
//		adminTemplate.update(userDTO, id_user);
//		return "redirect:/all";
//	}
//
//	
//	@RequestMapping(value = "/create", method = RequestMethod.POST)
//	public String createUser(HttpServletRequest request, @ModelAttribute("user") UserDTO userDTO) {
//		adminTemplate.creatUser(userDTO);
//		return "redirect:/all";
//	}
//	
//	
//	@RequestMapping(value = "/create", method = RequestMethod.GET)
//	public String createUserView(Model model) {
//		model.addAttribute("user", new UserDTO());
//		return "admin/adduser";
//	}
//	
//	//xoa
//	@RequestMapping(value = "/delete/{id_user}", method =  RequestMethod.GET)
//	public String delete(HttpServletRequest request, @PathVariable("id_user") Integer id_user) {
//		adminTemplate.delete(id_user);
//		return "redirect:/all";
//	}
//	
//	
//	
//	
//	
//}
