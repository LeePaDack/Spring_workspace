package com.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.dto.GoodsItem;
import com.kh.test.mapper.GoodsItemMapper;

@Service
public class GoodsItemService {

	@Autowired
	private GoodsItemMapper goodsItemMapper;
	
	public GoodsItem existsByName(String item_name) {
		return goodsItemMapper.existsByName(item_name);
	}
	
}
