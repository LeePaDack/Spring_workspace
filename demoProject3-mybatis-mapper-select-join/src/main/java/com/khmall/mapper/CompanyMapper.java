package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.SC;

@Mapper
public interface CompanyMapper {
	SC getCompanyById(int company_id);
}
