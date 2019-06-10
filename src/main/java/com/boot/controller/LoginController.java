package com.boot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.service.MemberService;
import com.boot.service.impl.MemberServiceImpl;
import com.boot.vo.Member;

@Controller 
public class LoginController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/") 
	public String index( ) { 
		return "index";
	}
	
	
	@RequestMapping("/registerPage") 
	public String registerPage( ) { 
		/*session.setAttribute("member", "문용성ㅋ");
		model.addAttribute("msg", "나와라고");*/
		return "regForm";
	}
	
	@RequestMapping("/registerMember") 
	public String registerMember(HttpSession session, HttpServletRequest reqeust, HttpServletResponse response, Model model) throws Exception { 
		System.out.println("registerMember");
		String id = reqeust.getParameter("id");
		String password = reqeust.getParameter("password");
		String name = reqeust.getParameter("name");
		System.out.println(id + " " + password + " " + name);
		Member member = new Member(id, password, name, "Normal");
		
		Member mem = memberService.selectMemberByID(id);
		System.out.println(member);
		System.out.println("=-------------");
		System.out.println(mem);
		if(mem != null) {
			model.addAttribute("msg", "이미 같은 ID가 존재합니다...");
		}else {
			memberService.addMember(member);
			model.addAttribute("msg", "환영합니다!");
		}
		
		
		session.setAttribute("member", member);
//		model.addAttribute("msg", "나와라고");
		return "index";
	}
	
	
	@RequestMapping("/loginPage") 
	public String loginPage(Model model) throws Exception { 
		model.addAttribute("msg", "환영합니다!");
		return "ttt";
	}
	
}

