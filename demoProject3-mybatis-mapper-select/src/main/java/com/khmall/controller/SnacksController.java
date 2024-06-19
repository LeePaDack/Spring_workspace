package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khmall.dto.Snacks;
import com.khmall.service.SnacksService;

@Controller
// Service 에 작성한 기능을 종합해서 DB 와 HTML 을 
// 연결해주는 연결고리
public class SnacksController {
	@Autowired // SnacksService 에 작성된 모든 기능 활용하겠다. (의존성 주입)
	private SnacksService snackService;
	
	
	@GetMapping("/allSnack")
	public String getAllSnack(Model model) {
		List<Snacks> snackList = snackService.getAllSnacks();
		//  <tr th:each=" s : ${snackList}">   html 에 전달할 목록들을
		// "" 안에 snackList 라는 변수명을 사용해서 전달하겠다 라는 표시
		// Model 은 DB 에서 가져온 값을 전달해주는 전달 연결고리
		model.addAttribute("snackList",snackList);
				// 스낵 서비스에서 추가적인 서비스 기능으로 다듬어진 메서드 가져오기
		// return "스낵리스트가 작성된 html 파일명 작성하기";
		return "snackList";
	}
}
