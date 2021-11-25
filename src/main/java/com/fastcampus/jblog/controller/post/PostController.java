package com.fastcampus.jblog.controller.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.jblog.biz.blog.BlogService;
import com.fastcampus.jblog.biz.blog.BlogVO;
import com.fastcampus.jblog.biz.post.PostService;
import com.fastcampus.jblog.biz.user.UserVO;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("createPost")
	public String createPost(HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("user");
		BlogVO blog = new BlogVO();
		
		blog.setUser_id(user.getUser_id());
		
		model.addAttribute("blog", blogService.getBlog(blog));
		
		return "adminPost";
	}
}
