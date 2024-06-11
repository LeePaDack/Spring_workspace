package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

// Bean : 스프링이 알아서 만들고 관리한다는 것

@Controller  // 응답 / 요청 제어 역할 명시 + Bean 등록
@RequestMapping("param")  // 여기 밑에 작성하는 모든 주소 앞에  param 이 기본으로 붙음
@Slf4j  // Simple Logging Facade for(4) Java 의 약자 --> System.out.println 과 비슷한 종류
// System 출력에 비해 logging 사용하는게 메모리 부담이 적음   log 를 이용한 메세지 출력시 자주 사용
public class ParameterController {
	
	// GETMAPPING main
	
	@GetMapping("main")  // param/main 이라는 주소로 GET 방식 요청 만듦
	public String paramMain() {
		return "param/param-main";
		// return 할 때 폴더명 / 파일명 작성
		// param-main.html 템플릿 밑에 param 이라는 폴더 밑에 존재
		// html 파일을 바라볼 때 기본으로 templates 이라는 폴더를 바라보고
		// templates/param/param-main.html 파일을 바라본다는 표시를 작성
	}
	
	@PostMapping("test1") // param/test1 POST 방식 요청
	public String paramTest1(HttpServletRequest req) {
		
		String inputName = req.getParameter("inputName"); 
		// form 밑에 input 에서 name 으로 inputName 존재하는 값 가져오기
		
		String inputAddress = req.getParameter("inputAddress");
		// form 밑에 input 에서 name 으로 inputAddress 존재하는 값 가져오기
		
		// 기본으로 가져오는 값이 String 이기 때문에 숫자값인 Int 로 변환
		int inputAge = Integer.parseInt(req.getParameter("inputAge"));
		// form 밑에 input 에서 name 으로 inputAge 존재하는 값 가져오기
		
		
		// inputName 과 inputAddress 와 inputAge 가 제대로 작성됐는지 확인
		System.out.println("이름 확인 : " + inputName);
		System.out.println("나이 확인 : " + inputAge);
		System.out.println("주소 확인 : " + inputAddress);
		
		
		// -> System 대신 log.debug 를 활용해서 출력하는 것이 메모리 부담
		// -> 코드 오류를 해결하기 위한 로그
		// -> 코드 오류는 없는데 정상적으로 수행이 안되거나
		// -? 값이 잘못된 경우 -> 값 추적
		log.info("정보 확인하기");
		log.debug("로그로 이름확인 : " + inputName);
		log.debug("로그로 나이확인 : " + inputAge);
		log.debug("로그로 주소확인 : " + inputAddress);
		
		
		/*
		spring 에서 Redirect(재요청) 하는 방법
		Controller 메서드 반환하는 값에
		redirect: 요청주소작성
		되돌아가짐
		 */
		
		return "redirect:/param/main";
		
	}
	
	/*
	2. @RequestParam - 낱개(한 개, 단수개) 파라미터 얻어오기
		
		- request 객체를 이용한 파라미터 전달 어노테이션
		- 매개 변수 앞에 해당 어노테이션을 작성하면, 매개변수에 값이 작성됨
		- 작성되는 데이터는 매개 변수(파라미터) 타입이 맞게 형변환(parse)이 자동으로 수행
		
	
	[속성 추가 작성법]
	@RequestParam(value="name", required="false", defaulValue="1")
	
	value = 전달받은 input 태그의 name 속성값
	
	required = 입력된 name 속성값 파라미터(매개변수) 필수 여부 지정 (기본값 true)
			-> required = true 인 파라미터가 존재하지 않는다면 400 Bad Request 에러 발생
			-> required = true 인 파라미터가 null 인 경우에도 400 Bad Request 에러 발생
			
	defaultValue = 파라미터 중 일치하는 name 속성 값이 없을 경우 대입할 값 지정
			-> required 가 false 일 경우 사용	
	 */
	
	// 400 Bad Request (잘못된 요청)
	// - 파라미터 불충분
	
	@PostMapping("test2")
	public String paramTest2(/* RequestParam 은 여기에 보통 작성 */) {
		log.info("문제없이 insert 가능한지 확인하기");
		return "redirect:/param/main";
	}
	
	
	
	
	
	
}
