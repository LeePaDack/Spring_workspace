package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
Java 객체 : new 연산자에 의해 Heap 영역에 클래스에서 작성된 내용대로 생성된 것

instance : 개발자가 만들고 관리하는 객체

bean : Spring Container(= Spring) 가 만들고 관리하는 객체



*/
@Controller  // 요청, 응답을 제어할 컨트롤러 역할 명시
			 // bean 으로 등록(= 객체로 생성해서 스프링이 관리)
public class HelloController {
	// 기존 Servlet : 클래스 단위로 하나의 요청만 가능
	// Spring : 메서드 단위로 요청 처리 가능
	
	// @RequestMapping("요청주소")
	// - 요청 주소를 처리할 메서드를 매핑하는 어노테이션
	
	// 1) 메서드에 작성
	// - 요청 주소와 메서드를 매핑
	// - GET / POST 를 가리지 않고 매핑 (속성을 통해 지정 가능)
	
	// 2) 클래스에 작성 :
	// - 공통적으로 사용되는 주소는 한 번에 매핑
	// Ex) 네이버/쇼핑, 네이버/블로그, 네이버/카페
	
	// @RequestMapping("네이버")
	// public class 클래스명{
	
		// @RequestMapping("블로그")
		// public String 메서드명(){}   // 네이버/블로그 매핑
	
		// @RequestMapping("카페")
		// public String 메서드명(){}   // 네이버/카페 매핑
		
		// @RequestMapping("쇼핑")
		// public String 메서드명(){}   // 네이버/쇼핑 매핑
	// }
	
	@RequestMapping("/test") //test 요청시 처리할 메서드 매핑
	public String testMethod() {
		System.out.println("/test 요청받았는지확인");
		return "test";
	}
	
	
}
