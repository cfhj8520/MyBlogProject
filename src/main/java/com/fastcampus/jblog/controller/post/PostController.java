package com.fastcampus.jblog.controller.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.jblog.biz.blog.BlogService;
import com.fastcampus.jblog.biz.blog.BlogVO;
import com.fastcampus.jblog.biz.category.CategoryService;
import com.fastcampus.jblog.biz.category.CategoryVO;
import com.fastcampus.jblog.biz.post.PostService;
import com.fastcampus.jblog.biz.post.PostVO;
import com.fastcampus.jblog.biz.user.UserVO;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("adminPost")
	public String adminPost(HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("user");
		BlogVO blog = new BlogVO();
		CategoryVO category = new CategoryVO();
		
		blog.setUser_id(user.getUser_id());
		blog = blogService.getBlog(blog);
		category.setBlog_id(blog.getBlog_id());
		
		model.addAttribute("blog", blog);
		model.addAttribute("categoryList", categoryService.getCategoryList(category));
		
		return "adminPost";
	}
	
	@RequestMapping("createPost")
	public String createPost(PostVO vo, HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("user");
		postService.insertPost(vo);
		
		return "redirect:/getBlog?user_id="+user.getUser_id();
	}
	
	@RequestMapping("getPostList")
	public String getPostList(PostVO vo, HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("user");
		postService.getPostList(vo);
		
		return "forward:/getBlog?user_id="+user.getUser_id();
	}
}
