package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

// Bean : 스프링이 만들고 관리하는 표시

@Controller  // -> 요청 / 응답을 받는 표시, 스프링에서 Controller 로 작성하라 명시되어 있음
@Slf4j // 각 메서드 이동할 때마다 log.info 사용해서 위치 이동 찍기
public class IndexController {
	
	@GetMapping("cafe/cafe-index") // 주소창에서 back 과 front 가 만나는 주소 (만남의 장소 위치)
	public String cafeMainMethod() {
		log.info("cafe index 메인으로 이동");
		return "cafe/cafe-index"; // html 파일 위치
	}
	
	// blog-index 로 이동하는 GetMapping 만들기
	@GetMapping("blog/blog-index")
	public String blogMainMethod() {
		log.info("blog index 메인으로 이동");
		return "blog/blog-index";
	}
	
	// blog-board 로 이동하는 GetMapping 만들기
	@GetMapping("blog/blog-board")
	public String blogBoardMethod() {
		log.info("blog board 로 이동");
		return "blog/blog-board";
	}
	
	// cafe-board 로 이동하는 GetMapping 만들기
	@GetMapping("cafe/cafe-board")
	public String cafeBoardMethod() {
		log.info("cafe board 로 이동");
		return "cafe/cafe-board";
	}
	
}
