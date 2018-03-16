package com.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/showlogin")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String userLogin(String username,String password,HttpSession session) {
		System.out.println(username);
		System.out.println(password);
		session.setAttribute("username", username);
		return "redirect:/itemList.action";
	}
}
