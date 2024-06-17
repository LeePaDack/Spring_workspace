package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Goods;
import com.example.demo.mapper.GoodsMapper;

@Service
public class GoodsService {
	@Autowired  // Context xml 파일로 한땀한땀 Mapper 위치랑 Service 위치를 설정하는 xml 파일을 만들어줘야함
	private GoodsMapper goodsMapper;
	
	public void insertGoods(Goods goods) {
		goodsMapper.insertGoods(goods);
	}
}
