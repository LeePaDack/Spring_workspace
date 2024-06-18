package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Goods;

@Mapper
public interface ProductMapper {
	void insertProduct(Goods goods);
	
	// 상품을 모두 가져올 때는 List Array 배열
	// List 로 상품들을 진열하겠다   상품 리스트 목록
	List<Goods> getAllProduct();
}
