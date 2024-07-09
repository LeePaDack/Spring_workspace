package com.kh.test.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper {
	Integer getGoods(String item_name);
	
	
}
