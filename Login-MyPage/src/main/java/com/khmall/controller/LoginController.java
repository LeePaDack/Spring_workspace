package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khmall.dto.Member;
import com.khmall.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
// @RestController -> 추후  REACT 를 사용할 때 사용할 예정
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("m", new Member());
		return "login";
	}
	
	@PostMapping("/login")
	public String getLogin(Model model,
						   @RequestParam("member_name") String member_name,
						   @RequestParam("member_phone") String member_phone,
						   HttpSession session) {
		Member member = memberService.getLogin(member_name, member_phone);
		// 만약에 로그인한 정보와 일치한다면 그대로 DB 에서 담아서 가져올 것이기 때문에 NULL 이 아님
		// 하지만 애초에 로그인할 정보가 다르면 DB 에서 출력이 되지 않기 때문에 NULL
		if(member != null) {
			session.setAttribute("loginSession", member);
			return "redirect:/";
		} else { // 값이 비어있거나 일치하는 정보가 없다면
			model.addAttribute("e", "일치하는 아이디 비밀번호가 없습니다.");
			model.addAttribute("m", new Member());
			return "login";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session /* SessionStatus status 시간지나면 자동 로그아웃 */) {
		session.invalidate(); // 로그인 없던일 만들기
		return "redirect:/";
	}
	
	@GetMapping("/myPage")
	public String showMyPage(HttpSession session, Model model) {
		// 현재 로그인이 된 세션의 정보를 가지고 와서 멤버 정보 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
		
		// 만약에 로그인이 되어있지 않은데 접촉하려한다. 그러면 홈페이지로 돌려보내기
		if(member == null) {
			return "redirect:/login";
		}
		// 만약 모델에 정보가 담겨있으면 보여줄 멤버 객체
		model.addAttribute("member", member);
		return "myPage";
	}
	
	/*****  마이페이지 블러오고 수정하는 GET POST  *****/
	@GetMapping("/modifyProfile")
	public String modifyMypage(HttpSession session, Model model) {
		// 현재 로그인이 된 세션의 정보를 가지고 와서 멤버 정보 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
				
		// 만약에 로그인이 되어있지 않은데 접촉하려한다. 그러면 홈페이지로 돌려보내기
		if(member == null) {
			return "redirect:/login";
		}
		model.addAttribute("member", member);
		return "modifyProfile";
	}
	/*
	Member updateMember 와 Member member
	Member updateMember 는 소비자(클라이언트)가 새롭게 작성하고 DB 에 덮어 쓸 내용이 임시 저장
	Member member       는 소비가(클라이언트)가 기존에 DB 에 저장한 값
	
	Member member = (Member) session.getAttribute("loginSession");
			 └-----> session 에서 loginSession 이라는 변수명에 저장된 로그인 정보를 가져오기 
			 		 가져와서 member 기존에 DB 에 저장된 값을 불러오기
	
	
	updateMember.setMember_id(member.getMember_id()); -- 덮어쓰기
			 └-----> DB 에 저장된 값 중 id는 개발자가 회원가입을 한 순번을 소비자한테 부여한 순서값으로
			 		 소비자가 가입한 순서는 변경할 수 없기 때문에 (소비자에 의해 변경될 수 없기 때문에)
			 		 id 값으로 소비자가 새롭게 input 창 안에 수정해서 작성한 값을 가져와서 임시저장
			 		 
			 		 setMember_id           member.getMemeber_id()
			 		 
			 		 					member.getMemeber_id() -- 기존에 DB 에 저장된 정보
			 		 setMember_id       -- 새롭게 DB 에 저장할 정보
			 		 												아이디(회원가입한순서)는 똑같지만 밑 내용은 다를 수 있음
			 		 
			 		 
			 		 
		memberService.updateMember(updateMember);
				└-----> 덮어쓰기한 내용을 DB 에 저장하기
		
		session.setAttribute("loginSession", updateMember);
				└-----> 새롭게 DB 에 저장한 내용을 loginsession 이라는 변수명에 다시 저장
	 */
	@PostMapping("/modifyProfile")
	public String updateMember(HttpSession session, Member updateMember) {
		// 현재 로그인이 된 세션의 정보를 가지고 와서 멤버 정보 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
				
		// 만약에 로그인이 되어있지 않은데 접촉하려한다. 그러면 홈페이지로 돌려보내기
		if(member == null) {
			return "redirect:/login";
		}
		updateMember.setMember_id(member.getMember_id());
		memberService.updateMember(updateMember);
		session.setAttribute("loginSession", updateMember);
		return "redirect:/myPage";
	}
	
	@GetMapping("/deleteMember")
	public String deleteMember(HttpSession session) {
		// 현재 로그인이 된 세션의 정보를 가지고 와서 멤버 정보 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
				
		// 만약에 로그인이 되어있지 않은데 접촉하려한다. 그러면 홈페이지로 돌려보내기
		if(member == null) {
			return "redirect:/login";
		}
		memberService.deleteMember(member.getMember_id()); // session 에 저장된 멤버 아이디를 가져오겠다
		session.invalidate(); // 삭제후 로그인 없던 일로 처리
		return "redirect:/";
	}
	
	// 검색하는 화면 보일 수 있도록 @GetMapping
	
	@GetMapping("/search")
	public String showSearchForm(Model model) {
		return "search";
	}
	
	
	/*
	@RequestParam("keyword") String keyword
	
	<input type="text" name="keyword" placeholder="이름 또는 전화번호 입력" required>
	
	@RequestParam("input 이나 태그에 작성한 name 또는 th 로 작성된 변수명") String keyword
	input 에서 name = "keyword" 이기 때문에 @RequestParam("keyword") 쓴 것
	input 에서 name , th:field 로 작성된 변수명과 무조건 일치해야함 @RequestParam("  ")
	
	
	String keyword 는 input 에서 바라보는 keyword 라는 값을 가져와서
	Java 에서 가져온 값을 담을 공간
	
	*/
	
	
	
	
	// 검색하는 결과 볼 수 있도록 @PostMapping
	@PostMapping("/search")
	public String searchMembers(Model model, @RequestParam("keyword") String keyword) {
		List<Member> member = memberService.searchMembers(keyword);
		model.addAttribute("results",member);
		return "search";
	}
	
}
