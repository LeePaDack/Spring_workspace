package com.khmall.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.khmall.dto.SC;
import com.khmall.service.SCService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class SCController {
	
	@Autowired
	private SCService scService;
	
	@GetMapping("/")
	// index 는 기본 주소가 / 임   특별히 특정한 기능을 넣지 않으면
	// /(기본 주소) 가 index 를 바라보기 때문에 작성을 생략해도 되지만
	// 특정한 값을 가져오거나 /(기본 주소) 가 index 이외에 다른 html 파일을 바라볼 때는
	// GetMappin("/") 에 기능이나 html 파일을 작성해줌
	public String getAllSC(Model model) {
		List<SC> sc = scService.getAllSC();
		log.info("모든 DB 값 가져오는지 확인하기" + sc);
		/*
		DTO 에서 @ToString 을 이용하지 않으면 DB 에서 가져오는 주소값만 보여지기 때문에 
		값을 제대로 가지고 았는지 확인하길 원하면 DTO 에 @ToString 추가
		
		만약에 값을 제대로 가져오지 못하면 null 이 뜰 것
		 */
		model.addAttribute("snackAndCompany",sc);
		
		return "index";
	}

	@GetMapping("/snack/{snack_id}") // 주소값이 변할 때는 변하는 변수를 {} 로 감싸줌
	// 주소값으로 id 숫자를 가져와서 주소값에 지정된 id 숫자와 일치하는 DB 값을 모두 가져오기
	public String getSnackById(Model model, @PathVariable int snack_id) {
		// 주소값으로 설정한 id 를 받아오고 scservice 에 전달해서 DB 에서 꺼내오기 작업
		SC sc = scService.getSnackById(snack_id);
		model.addAttribute("snack", sc);
		
		return "snackDetail";
	}






}
