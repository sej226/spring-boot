package com.boot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class LoginController {
	@RequestMapping("/login") 
	public String loginMember(HttpSession session, Model model) { 
		session.setAttribute("member", "문용성ㅋ");
		model.addAttribute("msg", "나와라고");
		return "regForm";
	}
	
	
	@RequestMapping("/") 
	public String index( ) { 
		return "index";
		}
	}

