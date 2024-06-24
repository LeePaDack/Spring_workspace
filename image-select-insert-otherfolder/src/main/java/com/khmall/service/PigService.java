package com.khmall.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Pig;
import com.khmall.mapper.PigMapper;

@Service
public class PigService {
	
	@Autowired
	// public PigService(PigMapper pigMapper){
	// 		this.pigMapper = pigMapper;
	// }
	// 서비스에서 추가적을 수정된 데이터가 매퍼를 통해 DB 에 들어가고
	// 데이터 베이스에서 가져온 SQL 에 추가적으로 수정을 서비스 단계에서 진행한 다음 컨트롤러에 전달하거나 전달받기
	
	private PigMapper pigMapper;
	
	// 1. 돼지정보 전체 리스트 -> List(DTO Pig) 
	public List<Pig> getAllPigs(){
		return pigMapper.getAllPigs();
	}
		
	// 2. 돼지정보 하나만 가져오기 -> DTO Pig
	public Pig getPigById(int pig_id) {
		return pigMapper.getPigById(pig_id);
	}
		
	// 3. 돼지정보 DB 에 업로드하기 -> void(Pig)
	//public void uploadPig(Pig pig) { -> 돼지 정보를 저장할 때 경로나 이름 아무것도 변경할게 없을 때 사용
	public void uploadPig(String pig_name, int pig_age, MultipartFile file) {
		// 만약에 파일 이름을 저장하길 원한다면 이미지 업로드할 때 임시저장 되어있는 이미지 파일이름 가져옴
		String 파일이름 = file.getOriginalFilename();
		
		// 바탕화면에 pigImg 라는 폴더가 없으면 생성하게끔 작성
		String 이미지저장폴더 = "C:/Users/user1/Desktop/pigImg/";
		File 폴더경로확인 = new File(이미지저장폴더);
		// 만약에 저장하고자하는 이미지 폴더가 존재하지 않을 경우 경로들 모두 생성
		// exist -> File 자료형에서만 생성
		if (!폴더경로확인.exists()) {
			폴더경로확인.mkdirs(); // mkdir = 폴더 한 개    mkdirs = 폴더 여러 개
			// mkdir 써도 되긴 하지만 혹시 모를 문제를 최소화 하기 위해 mkdirs 를 사용
		}
		// 폴더가 안전하게 생성됐는지 확인을 모두 마치고 지정된 폴더에 사진 올리기
		File 사진파일올리기 = new File(이미지저장폴더 + 파일이름);
		String DB에파일경로및파일명전달 = 이미지저장폴더 + 파일이름;
		try {
			file.transferTo(사진파일올리기);
			// 모든 준비가 끝났으니 이미지 정보를 DB 에 전달해주기
			Pig pig = new Pig();
			pig.setPig_name(pig_name);
			pig.setPig_age(pig_age);
			pig.setPig_image_path(DB에파일경로및파일명전달); // String 값이기 때문에 File 자료형이 올 수 없음
			
			pigMapper.uploadPig(pig);
			System.out.println("Mapper 에 Service 로 pig insert 전달 성공");  // 나중에 log 로 변경
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
