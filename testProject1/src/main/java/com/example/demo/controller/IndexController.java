package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/test") //test 요청시 처리할 메서드 매핑
	public String testMethod() {
		System.out.println("/test 페이지로 제대로 연결 됐는지 확린 메서드 출력");
		
		/*
		@RequestMapping 을 쓰면 기본적으로 return 할 때 html 파일을 바라보겠다 설정이 들어있음
		
		classpath : scr/main/resource
		기본 경로 앞에 붙여진 /templates/ 폴더가 html 을 담는 공간
		파일명 마지막에는 항상 .html 이 붙는다
		 */
		
		return "test"; // srt/main/resource/templates/test.html 로 이동하겠다 라는 표시
		// return "html파일명";
		// 돌아가기 "html파일명";
		
		
	}
}
