package com.khmall.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString // 나중에 값이 제대로 안넘어올때 안넘어오는 이유를 확인하는 String
public class Member {
	private int member_id;
	private String member_name;
	private int member_age;
	private String member_phone;
}
