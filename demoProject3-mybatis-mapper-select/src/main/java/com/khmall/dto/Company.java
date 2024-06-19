package com.khmall.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Company {
	private int company_id;
	private String company_name;
	private String company_address;
	private String company_phone; // 핸드폰 번호는 앞이 0 으로 시작하기 떄문에 String 으로 해줌
	// int 는 맨 앞 0 을 자동으로 없애주기 때문
}
