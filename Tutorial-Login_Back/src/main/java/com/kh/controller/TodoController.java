package com.kh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.dto.TodoMember;
import com.kh.service.TodoService;

import lombok.extern.slf4j.Slf4j;

// SpringBoot 어플리케이션(폴더 안)에서 HTML 코드를 작성해주는 것이 아니라
// React 나 외부로 url 주소 공유할 때 사용

@RestController
@Slf4j
public class TodoController {
	@Autowired
	private TodoService service;
	
	/** 아이디 중복검사
	 * @param(파라미터 = 매개변수 = 중간에 개입해서 값을 변하게 하는 수)
	 * @param id 값을 가져와서 아이디 중복 결과를 보여줄 것
	 * @return 아이디 중복 확인 후에 결과를 되돌려 주는 것
	 * @return 중복 : 1, 사용 가능 : 0
	 */
	
	@GetMapping("idCheck")
	public int idCheck(@RequestParam("id") String id) {
		return service.idCheck(id);
	}
	
	/** 회원가입
	 * @param member 회원가입할 때 작성한 정보를 모두 가져오기
	 * @return 회원가입을 성공하면 : 1  실패하면 : 0 을 줄 것
	 * 
	 * @Request      DB 에 특정 값이 있는지, 또는 값을 넣겠다, 값을 수정하겠다 요청
	 * @RequestParam 특정 값민 선턱해서 요청, 특정 값을 변환해서 요청
	 * @RequestBody  프론트에서 작성하고 Body 로 전달해주는 모든 값을 넣어주겠다.
	 * 				 우리가 사용하는 React 기준 
	 * 				 body : JSON.stringify(input값들)
	 * 			 	 input값들 에 DB 로 넣어주겠다는 모든 값을 DB 에 넣겠다 선언
	 * 
	 * @Response       DB 에서 전달받은 값을 프론트에 전달할 때 사용
	 * @ResponseParam  특정 값만 프론트에 전달
	 * @ResponseBody   HTML 에서 BODY 보여줄 모든 값을 전달
	 */
	@PostMapping(value="/signup")
	public int signup(@RequestBody TodoMember member) {
		return service.signup(member);
	}
	
	/** 로그인
	 * @param member
	 * @return 성공 : 회원정보와 / todoList 를 볼 수 있는 정보 제공, 실패 : null
	 */
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody TodoMember member) {
		return service.login(member);
	}
	
	
}
