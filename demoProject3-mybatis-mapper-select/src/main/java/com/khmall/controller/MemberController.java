package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.khmall.dto.Member;
import com.khmall.service.MemberService;

@Controller
public class MemberController {
	@GetMapping("/memberRegister")
	public String memberRegister(Model model) {
		model.addAttribute("member", new Member());
		return "memberRegister";
	}
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/memberRegister")
	public String insertMember(Member member, Model model) {
		memberService.insertMember(member);
		List<Member> memberList = memberService.getAllMember();
		model.addAttribute("memberList", memberList);
		return "memberList";
	}
	
	@GetMapping("/allMember")
	public String getAllMember(Model model) {
		List<Member> memberList = memberService.getAllMember();
		model.addAttribute("memberList", memberList);
		return "memberList";
	}
}