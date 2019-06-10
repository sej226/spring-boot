package com.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		return "regForm";
	}
	
	@RequestMapping("/registerMember") 
	public String registerMember(HttpSession session, HttpServletRequest reqeust, HttpServletResponse response, Model model) throws Exception { 
		System.out.println("registerMember");
		String id = reqeust.getParameter("id");
		String password = reqeust.getParameter("password");
		String name = reqeust.getParameter("name");
		System.out.println(id + " " + password + " " + name);
		Member member = new Member(id, password, name, "Intermediate");
		
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
		return "login";
	}
	
	@RequestMapping("/loginMember") 
	public String loginMember(HttpSession session, HttpServletRequest reqeust, HttpServletResponse response, Model model) throws Exception { 
		System.out.println("loginMember");
		String id = reqeust.getParameter("id");
		String password = reqeust.getParameter("password");
		String name;
		System.out.println(id + " " + password  );
		
		Member member = memberService.selectMemberByID(id);
		session = reqeust.getSession();
		System.out.println(member);
		
		if(member != null) {
			session = reqeust.getSession(true); 
			session.setAttribute("member", member);
			model.addAttribute("msg", "환영합니다!");
		}else {
			model.addAttribute("msg", "로그인에 실패했습니다.");
		}
		return "index";
	}
	@RequestMapping("/logoutPage") 
	public String logoutPage(HttpSession session, HttpServletRequest reqeust, HttpServletResponse response) throws Exception { 
		reqeust.getSession().invalidate();
		return "index";
	}
	
	@RequestMapping("/managementMemberPage") 
	public String managementMemberPage(Model model) throws Exception { 
//		List<Member> members = memberService.selectAllMember();
//		model.addAttribute("members", members);
		return "management";
	}
	
}

