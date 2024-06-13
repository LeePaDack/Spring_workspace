package com.example.demo.dto;

import lombok.*;
/*
 * Spring 같은 경우 getter 가 필수로 있어야 함
 * -> ${StudentDTO.getName()} == ${StudentDTO.name}
 * 		getter 대신 필드명 호출하는 형식 작성
 * 		이게 가능한 이유는 getter 자동으로 호출한다 생각하기 때문
 * */
@Getter    			// getter 코드 자동 추가
@Setter    			// setter 코드 자동 추가
@ToString  			// toString() 메서드가 자동으로 오버라이딩 돼서 추가
@NoArgsConstructor	// 기본생성자(매개변수가 없는 생성자)
@AllArgsConstructor // 필수생성자(모든 필드를 가지고 있는 매개변수 생성자)
public class StudentDTO {
//필드
	private String studentNo; //학번
	private String name;	  //이름
	private int age; 		  //나이
}