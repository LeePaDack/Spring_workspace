package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter    			// getter 코드 자동 추가
@Setter    			// setter 코드 자동 추가
@ToString  			// toString() 메서드가 자동으로 오버라이딩 돼서 추가
@NoArgsConstructor	// 기본생성자(매개변수가 없는 생성자)
@AllArgsConstructor // 필수생성자(모든 필드를 가지고 있는 매개변수 생성자)
public class MemberDTO {
	private String memberNo;
	private String memberName;
	private String memberAge;
}
