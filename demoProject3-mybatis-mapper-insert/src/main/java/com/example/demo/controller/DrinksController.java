package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Drinks;
import com.example.demo.service.DrinksService;

public class DrinksController {
	@GetMapping("/")
	public String registerForm(Model model) {
		model.addAttribute("drinks", new Drinks());
		return "index";
	}
	
	@Autowired
	private DrinksService drinksService;
	
	@PostMapping("/drink-register")
	public String insertDrinks(Drinks drinks, Model model) {
		drinksService.insertDrinks(drinks);
		// log
		model.addAttribute("msg1","음료가 성공적으로 등록됐습니다.");
		return "successDrink";
	}
	
	
	
	
	
	
	
	
	
	
}
