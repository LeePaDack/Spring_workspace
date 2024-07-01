package com.khmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.SC;
import com.khmall.mapper.CompanyMapper;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyMapper companyMapper;
	
	public SC getCompanyById(int company_id){
		return companyMapper.getCompanyById(company_id);
	}
}
	