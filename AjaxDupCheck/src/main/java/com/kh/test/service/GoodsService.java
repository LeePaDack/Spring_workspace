package com.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.mapper.GoodsMapper;

@Service
public class GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	
	public boolean getGoods(String item_name) {
		Integer count = goodsMapper.getGoods(item_name);
		// null 이 아니다 0 또는 1 이상 count 0 보다 클 때 반환
		return count != null && count > 0; // null 이 아니다
	}
}
