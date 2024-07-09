package com.kh.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.service.GoodsItemService;

@Controller
public class GoodsItemController {

	@Autowired
	private GoodsItemService goodsItemService;
	
	
	@GetMapping("/check")
	public String existsByName() {
		return "";
	}
	
}
