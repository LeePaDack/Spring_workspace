package com.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.dto.GoodsItem;
import com.kh.test.mapper.GoodsItemMapper;

@Service
public class GoodsItemService {
	@Autowired
	private GoodsItemMapper goodsItemMapper;
	/*
	@Autowired 는 아래와 같은 표현을 가지고 있음
	public GoodsItemService(GoodsItemMapper goodsItemMapper) {
		this.goodsItemMapper = goodsItemMapper;
	}
	 */
	
	public boolean existsByName(String itemName) {
		// Integer 로 맞춘 후 Integer 를 boolean 으로 변경해서 전달할 예정
		// Integer count = goodsItemMapper.existsByName(itemName); -> resultMap 사용하지 않은 방식
		GoodsItem count = goodsItemMapper.existsByName(itemName); // resultMap 을 사용한 방식
		// Integer totalCount = 참인지 거짓인지 ? true 이고 null 이 아닐 때 : false null = 0;
		Integer totalCount = count != null ? count.getItemCount() : 0;
 		return totalCount != null && totalCount > 0; // true 라고 전달할 예정  return = boolean 
		
		
		// return goodsItemMapper.existsByName(itemName);
		// Type mismatch: cannot convert from Integer to boolean  
		// Mapper 에서는 Integer 를 작성하고, service 에서 반납할 때는 boolean 을 사용해서
		// 타입 불일치,      Mapper 랑 Service 둘다 모두 Integer = int 로 작성하거나 
		// Mapper 랑 Service 모두 boolean 으로 작성하기
	}
}
