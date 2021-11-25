package com.fastcampus.jblog.controller.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.jblog.biz.post.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@RequestMapping("createPost")
	public String createPost() {
		return "adminPost";
	}
}
