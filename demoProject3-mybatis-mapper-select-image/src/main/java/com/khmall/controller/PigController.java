package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Pig;
import com.khmall.service.PigService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PigController {
	@Autowired
	private PigService pigService;
	
	@GetMapping("/")
	public String getAllPigs(Model model) {
		List<Pig> pigs = pigService.getAllPigs();
		model.addAttribute("pigs", pigs);
		return "index";
	}
	
	/*
	// application.properties 에 error 경로를 지정하고 설정에서 지정된 경로를 찾아 발생
	@RequestMapping("/error")
	public String getError() {
		return "error";
	}
	*/
	
	@GetMapping("/pigDetail/{pig_id}")
	public String getPigById(Model model, @PathVariable int pig_id) {
		Pig pig = pigService.getPigById(pig_id);
		model.addAttribute("pig",pig);
		return "pigDetail";
	}
	
	/***** 돼지 정보를 올릴 수 있는 주소로 이동하는 GetMapping 작성하기 *****/
	@GetMapping("/imgUpload") // html 파일과 java 파일이 만나는 공간
	public String uploadForm(Model model) {
		model.addAttribute("p", new Pig()); // DB 에 올릴 수 있는 공간을 만들어줌
		return "imgUpload"; // html 이름 작성
	}
	
	
	/***** 돼지 정보 DB 에 업로드 PostMapping *****/
	@PostMapping("/upload")
	public String uploadPig(
			// @RequestParam 을 읽어서 파일을 하나씩 가져오겠다 설정
			@RequestParam("pig_name") String pig_name,
			@RequestParam("pig_age") int pig_age,
			@RequestParam("pig_image_path") MultipartFile file
			, Model model) { // @RequestParam
		pigService.uploadPig(pig_name,pig_age,file);
		log.info("pigUpload확인");
		return "redirect:/"; // 업로드 완료되면 메인페이지로 가서 제대로 등록되었는지 확인
		// redirect:/   index  의 차이점
		/*
		
		redirect:/  =  사용자가 새로운 url 로 다시 요청하도록 지시
		-> react 로 작성하고 나서 값을 전달할 때 주로 사용할 예정
		
		index  =  html 파일 이름을 의미
		
		 */
	}
}
