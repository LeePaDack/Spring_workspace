package com.khmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.Company;
import com.khmall.mapper.CompanyMapper;

@Service
public class CompanyService {

	@Autowired
	private CompanyMapper companyMapper;
	
	public List<Company> getAllCompany(){
		return companyMapper.getAllCompany();
	}
}
