package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("param") // ParameterController 밑에는 모두 자동으로 맨 앞에 param 이 붙음
public class ParameterController {

	@GetMapping("main")
	public String paraMain() {
		return "param/param-main";  // 폴더에서 param 안에 있는 param-main.html 파일 바라보기
	}
	
	@PostMapping("test1")
	public String paramTest1(HttpServletRequest req) {
		String inputName = req.getParameter("inputName"); 
		
		String inputAddress = req.getParameter("inputAddress");

		int inputAge = Integer.parseInt(req.getParameter("inputAge"));
		// String 에서 int 로 형변환
		
		log.info("시작했는지 확인");
		
		log.debug("이름 확인 : " + inputName);
		log.debug("주소 확인 : " + inputAddress);
		log.debug("나이 확인 : " + inputAge);
		
		log.info("//////////////////////////////");
		
		log.debug("이름 확인 : " + inputName);
		log.debug("주소 확인 : " + inputAddress);
		log.debug("나이 확인 : " + inputAge);
		
		
		return "redirect:/param/main"; // 작성 다 되면 메인으로 돌아가기
	}
	
}
