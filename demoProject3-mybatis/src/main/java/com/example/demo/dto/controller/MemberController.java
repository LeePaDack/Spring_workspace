package com.example.demo.dto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;

@Controller  // DB 와 templates 을 연결해주는 연결고리
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	// 회원가입을 위해 작성할 GetMapping 작성하기
	@GetMapping("/register")
	public String 회원가입품보기(Model model) {
		model.addAttribute("mem",new Member());
		return "index";
	}
	// 나중에 회원가입을 완료하면 보일 PostMapping
	@PostMapping("/register")
	public String 회원가입완료(Member member, Model model) {
		// 회원가입 작성이 완료가 되면 db 에 저장하겠다.
		memberService.멤버가입(member);
		// model.addAttribute("select 로 DB 에 저장된 회원가입 정보 가져오기")
		model.addAttribute("msg","멤버가 성공적으로 가입되었습니다.");
		return "success";
	}
}
