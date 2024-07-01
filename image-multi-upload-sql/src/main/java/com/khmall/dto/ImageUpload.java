package com.khmall.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImageUpload {
	private int id;
	private String file_name;
	private String upload_dir;
}
