package com.khmall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.khmall.dto.Member;

@Mapper
public interface MemberMapper {
	/* 	Member getLogin(@Param("member_name")String member_name, 
					@Param("member_phone")String member_phone);
	@Param 앞에서 매개변수인 파라미터를 이용해서 값을 일치하는 값을 가져온다고
	한 번 더 확실하게 작성해주는 것				
					 */
	Member getLogin(@Param("member_name")String member_name, 
					@Param("member_phone")String member_phone);
}
