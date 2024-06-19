package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Company;

@Mapper
public interface CompanyMapper {

	List<Company> getAllCompany();
}
