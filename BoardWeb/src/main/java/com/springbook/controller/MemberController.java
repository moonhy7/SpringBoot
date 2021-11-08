package com.springbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbook.service.MemberService;
import com.springbook.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/login.do")
	public String login() {
		return "login";
	}
	
	@PostMapping("/loginSuccess.do")
	public String loginSuccess() {
		return "loginSuccess";
	}
	
	@GetMapping("/logout.do")
	public String logout() {
		return "login";
	}
	
	@GetMapping("/join.do")
	public String joinView() {
		return "join";
	}
	
	@PostMapping("/join.do")
	public String join(MemberVO vo) {
		String password = vo.getPassword();
		
		vo.setPassword(encoder.encode(password));
		
		memberService.join(vo);
		return "join";
		
	}
}
