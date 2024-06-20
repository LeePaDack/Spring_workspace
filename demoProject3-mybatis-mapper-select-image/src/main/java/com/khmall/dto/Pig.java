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
@ToString
public class Pig {
	private int pig_id; 
	private String pig_name;
	private int pig_age; 
	private String pig_image_path;
}
