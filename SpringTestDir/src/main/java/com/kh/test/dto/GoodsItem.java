package com.kh.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoodsItem {
	private int itemId;
	private String itemName;
	private String itemDes;
	
	// Count 결과를 받아서 저장할 변수명을 추가
	private Integer itemCount; // COUNT(*)
	
	// itemName
}
