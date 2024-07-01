package com.khmall.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ImageUploadMapper {
	// void insertImageUpload(ImageUpload imageUpload);
	/*
	Controller 에서 paramMap 을 Mapper 로 전달할 떄
	imageUploadMapper.insertImageUpload(paramMap);
	
	paramMap 맨 앞에
	Map<String, Object> paramMap
	
	Map 과 String Object 를 작성해줬기 때문에
	Mapper 에서도 Map<String, Object> 를 붙여줌
	 */
	void insertImageUpload(Map<String, Object> paramMap);
}
