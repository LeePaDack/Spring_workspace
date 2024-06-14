package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Member;

/*
DB 에 어떤 값을 보거나 넣거나 삭제하거나 수정하는 것을
작성만 해주는 공간 
*/
@Mapper // Mapper 라는 명칭 지정
public interface MemberMapper {
	// 멤버가 새로 가입하면 DB 에 넣어주기
	void insertMember(Member member);
}
