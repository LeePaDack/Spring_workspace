package com.example.demo.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 *  Getter 와 Setter 는 Lombok 라이브러리 활용해서
 * 	길게 작성하지 않음
 *  기본생성자
 * 
 * */
@Getter
@Setter
@NoArgsConstructor  // 기초 생성자
@ToString
public class MemberDTO {
	// 나중에 db 랑 연결할 모델들 작성
// 필드
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	
// 메서드
	// Getter -> lombok @Getter 자동완성 사용하기
	// Setter -> lombok @Setter 자동완성 사용하기
	// 기본생성자 -> lombok @NoArgsConstructor 자동완성 사용하기
	// 필수생성자 -> lombok @AllArgsConstructor 자동완성 사용하기
	// tostring -> lombok @ToString 자동완성 사용하기
}
