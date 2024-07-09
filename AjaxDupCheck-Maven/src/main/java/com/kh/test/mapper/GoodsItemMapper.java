package com.kh.test.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.test.dto.GoodsItem;

@Mapper
public interface GoodsItemMapper {
	
	GoodsItem existsByName(String item_name);
	
}
