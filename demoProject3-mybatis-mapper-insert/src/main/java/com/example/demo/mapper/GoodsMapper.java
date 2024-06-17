package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Goods;

/* 완벽한 기능을 작성하는 공간이 아니라
Mapper.xml 에 작성한 id 리스트를 모두 리스트만 작성하는 공간이기 때문에
interface 로 작성
mapper.xml 어떤 파일이 존재한다. 존해나느 리스 작성란
@Mapper 라는 어노테이션을 확용해서 SpringBoot 가 Mapper 를 찾을 수 있도록 설정
*/
@Mapper // sql 사용할 리스트 목록
public interface GoodsMapper {
	void insertGoods(Goods goods);
}
