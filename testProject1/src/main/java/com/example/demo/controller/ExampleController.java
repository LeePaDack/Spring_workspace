package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // 어노테이션 컨트롤러
public class ExampleController {

	// 어노테이션 겟매핑    
	@GetMapping("example") // /example Get 방식 요청 매핑
	public String exampleMethod() {
		return "example";
	}
}