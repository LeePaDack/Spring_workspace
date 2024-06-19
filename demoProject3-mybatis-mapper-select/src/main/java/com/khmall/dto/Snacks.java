package com.khmall.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Snacks {
	private int snack_id;
	private String snack_name;
	private int price;
	private int company_id;
}
