package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Drinks;

@Mapper
public interface DrinksMapper {
	void insertDrinks(Drinks drinks);
}
