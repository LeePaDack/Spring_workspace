package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khmall.dto.Company;
import com.khmall.service.CompanyService;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/companyList")
	public String getAllCompany(Model model) {
		List<Company> companyList = companyService.getAllCompany();
		model.addAttribute("comList",companyList);
		return "companyList";
		
	} 
}
