package com.kh.service;

import java.util.Map;

import com.kh.dto.TodoMember;

public interface TodoService {
	int idCheck(String id);
	int signup(TodoMember member);

	// login 의 경우 key value 값을 이용해서 정보를 전송
	Map<String, Object> login(TodoMember member);
}