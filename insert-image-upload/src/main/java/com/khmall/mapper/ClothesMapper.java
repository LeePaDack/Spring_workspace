package com.khmall.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Clothes;

@Mapper
public interface ClothesMapper {
	public void uploadClothes(Clothes clothes);
}
