package com.example.demo.dto;

import lombok.*;

/* lombok 확용한 Getter Setter 기초생성자 필수생성자 toString 만들기 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Goods {
	private int goodsId;
	private String goodsName; 
	private int goodsPrice;
	private int goodsQuantity;
}
