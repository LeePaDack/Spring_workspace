package com.khmall.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
	private int goods_id;
	private String goods_name;
	private int goods_price;
	private int goods_quantity;
}
