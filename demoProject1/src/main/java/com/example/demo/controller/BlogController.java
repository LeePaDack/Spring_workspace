package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.dto.BlogDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("blog")
@Slf4j
public class BlogController {

	@PostMapping("comment")
	public String blogComment(BlogDTO blogDTO) {
		
		log.info("블로그 댓글 작성 공간");
		
		BlogDTO bd = new BlogDTO();
		bd.getCommentName();
		bd.getCommentOpinion();
		
		
		bd.setCommentName("홍길동");
		bd.setCommentOpinion("잘봤습니다");
		
		log.info("bd 에 작성한 내용 보기" + bd.toString());
		return "redirect:/blog/blog-index";
	}
	
}
