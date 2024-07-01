package com.khmall.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;


/*
 * html 파일과 db가 주고받을 때는 Service 라는 이름으로 
 * 코드를 작성하지만
 * 백엔드에서 단독적으로 진행하는 값이나 공통으로 설정할 때는
 * util이라는 이름을 사용해서 코드를 작성
 * 
 * util -> postMan을 사용해서 파일업로드가 잘 되고 있는 지 테스트 진행
 * */

// DB 랑 아무런 관련 X 오로지 파일이 내 컴퓨터에 무사히 저장되는지 확인하는 용도의 코드이기 때문에 Service 가 아님
public class ImageUploadUtil {
	public static void insertImageUpload(String uploadDir, 
										 String fileName, 
										 MultipartFile multipartfile) throws IOException {
			// 컨트롤러에서는 MultipartFile[] 배열모양 => 서비스에서 하나씩 올린 파일을 모두 전송
			// 서비스에서는 MultipartFile 모양이 배열이 아님 => 파일을 하나씩 올리는 작업
		//import java.nio.file.Path; import java.nio.file.Paths;
		Path uploadPath = Paths.get("C:/" + uploadDir);
		
		//만약에 폴더가 존재하지 않으면 폴더 생성
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		
		try(InputStream inputStream = multipartfile.getInputStream()){
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}