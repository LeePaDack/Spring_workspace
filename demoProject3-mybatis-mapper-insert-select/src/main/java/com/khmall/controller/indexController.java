package com.khmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khmall.dto.Goods;

@Controller
public class indexController {
/* index html 로 주소를 이동할 때 사용하는 GetMapping 작성 */
	@GetMapping("/productRegister")
	public String goodsRegister(Model model) {
		model.addAttribute("goods",new Goods());
		return "productRegister";
	}
}
