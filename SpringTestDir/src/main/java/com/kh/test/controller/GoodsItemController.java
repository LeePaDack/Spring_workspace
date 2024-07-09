package com.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.test.service.GoodsItemService;

@RestController   // 만약 에러로 template [check] @Controller -> @RestController
public class GoodsItemController {
	@Autowired
	private GoodsItemService goodsItemService;
	
	@GetMapping("/check")
	public Map<String,Boolean> existsByName(@RequestParam String itemName) {
		// 만약에 상품명이 조회가 된다면 이미 존재하는 상품명입니다. 만들기
		
		boolean isCheck = goodsItemService.existsByName(itemName);
		Map<String, Boolean> res = new HashMap<>();
		
		// String itemName   Object isCheck
		// ajax 는 html 을 return 으로 작성하지 않음
		// 왜냐하면 html 파일을 불러오는 것이 아니라
		// html 파일의 일부분만 설정하는 것이기 때문에
		res.put("isCheck", isCheck);
		
		return res; // Map 으로 전달된 key value 를 다시 html 파일에서 중복체크에 전달
	}
}
