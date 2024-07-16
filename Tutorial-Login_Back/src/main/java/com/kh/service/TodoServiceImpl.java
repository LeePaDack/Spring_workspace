package com.kh.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dto.TodoMember;
import com.kh.mapper.TodoMapper;
/*
Service ServiceImpl
Service = 코드 작성하는데 있어 이런 서비스를 사용하겠다는 계약 정의
어떤 메서드들(기능들)이 있어야하는지, 그 메서드들(기능들)이 어떤 역할을 하는지 정의
ServiceImpl = 인터페이스로 작성한 Service 의 실제 기능을 작성
비슷한 기능을 각 서비스에 맞춰서 사용하겠다는 의미

Ex) createUser = user 를 만들 것임
user 를 만드는 도중 관리자 - 소비자를 나눠서 만들 것
 */


@Service
public class TodoServiceImpl implements TodoService{
	@Autowired
	private TodoMapper mapper;
	
	
	// interface 에 기능 명시가 되어있고
	// 명시된 기능을 완벽하게 만든다는 @Override = 재사용 이라는 표기를 작성
	// 개발자간의 약속, 생략 가능하긴하지만 작성해주는 것이 좋음
	@Override
	public int idCheck(String id) {
		return mapper.idCheck(id);
	}
	
	@Override
	public int signup(TodoMember member) {
		return mapper.signup(member);
	}
	
	@Override
	public Map<String, Object> login(TodoMember member) {
		TodoMember loginMember = mapper.login(member);
		
		Map<String, Object> map = new HashMap<>();
		map.put("loginMember", loginMember);
		
		return map;
	}
}