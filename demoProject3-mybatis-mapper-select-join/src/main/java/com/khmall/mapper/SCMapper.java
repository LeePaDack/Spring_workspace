package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.SC;

@Mapper
public interface SCMapper {
	// getAllSC 로 가져온 select join 문을 보여주기
	List<SC> getAllSC();

	// 위에서는 모든 제품을 가져오기 때문에 List 를 작성 했지만
	// 아래는 하나의 값만 가져오기 때문에 List 를 없애준 것
	// snack_id 에 해당하는 값을 가져오겠다. 라는 표기
	SC getSnackById(int snack_id);
}
