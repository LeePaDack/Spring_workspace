
package com.khmall.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.khmall.dto.SC;
import com.khmall.service.CompanyService;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService  companyService;

	
	@GetMapping("/company/{company_id}") // 주소값이 변할 때는 변하는 변수를 {} 로 감싸줌
	// 주소값으로 id 숫자를 가져와서 주소값에 지정된 id 숫자와 일치하는 DB 값을 모두 가져오기
	public String getCompanyById(Model model, @PathVariable int company_id) {
		// 주소값으로 설정한 id 를 받아오고 scservice 에 전달해서 DB 에서 꺼내오기 작업
		SC sc = companyService.getCompanyById(company_id);
		model.addAttribute("company", sc);
		
		return "companyDetail";
	}
}
