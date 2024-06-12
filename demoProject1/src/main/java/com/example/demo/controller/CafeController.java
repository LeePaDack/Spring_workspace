package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.dto.CafeDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("cafe")
@Slf4j
public class CafeController {
	/*
	@PostMapping("cafe-index") 
	public String cafeMainComment(@RequestParam("cafeCommentName") String cafeCommentName,
								  @RequestParam("cafeCommentOpinion") String cafeCommentOpinion
			){
		log.info("카페 의견 작성 공간");
		
		log.debug("cafeCommentName : " + cafeCommentName);
		log.debug("cafeCommentOpinion : " + cafeCommentOpinion);
		
		log.info("의견 작성 완료");
		
		return "redirect:/cafe/cafe-index";
	}
	*/
	
	// cafeDTO 이용해서 cafe-board   
	// @PostMapping("cafe-index") ModelAttribute 받아오기
	@PostMapping("comment") 
	public String cafeIndexComment(CafeDTO cafeDTO) {
		CafeDTO cd = new CafeDTO();
		cd.getCafeCommentName();
		cd.getCafeCommentOpinion();
		
		cd.setCafeCommentName("넣어줄 값 = 나중에 DB 연결해서 전달해줄 것");
		cd.setCafeCommentOpinion("넣어줄 값 = 나중에 DB 연결해서 전달해줄 것");
		return "";
	}
}
