package com.khmall.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Clothes;
import com.khmall.mapper.ClothesMapper;

@Service
public class ClothesService {
	
	@Autowired
	private ClothesMapper clothesMapper;
	
	public void uploadClothes(String clothes_name,int clothes_price,String clothes_category, MultipartFile file ) {
		String fileName = file.getOriginalFilename();
		
		String uploadDir = "C:/Users/user1/servlet_jsp_workspace/insert-image-upload/src/main/resources/static/images/";
		
		File imgFile = new File(uploadDir + fileName);
		
		if(!imgFile.exists() /* 만약에 이미지 폴더가 존재하지 않을 때가 true 인 ! 추가 */) {
			// 폴더 생성하기
			imgFile.mkdirs(); // 폴더가 존재하지 않을 경우 우리가 지정한 폴더에 생성
		}
		
		try {
			file.transferTo(imgFile);
			Clothes clothes = new Clothes();
			clothes.setClothes_name(clothes_name);
			clothes.setClothes_price(clothes_price);
			clothes.setClothes_category(clothes_category);
			clothes.setClothes_image_path("/images/" + fileName);
			
			clothesMapper.uploadClothes(clothes);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
