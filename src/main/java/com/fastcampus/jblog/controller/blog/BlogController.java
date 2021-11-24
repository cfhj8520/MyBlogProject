package com.fastcampus.jblog.controller.blog;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.jblog.biz.blog.BlogDAO;
import com.fastcampus.jblog.biz.blog.BlogService;
import com.fastcampus.jblog.biz.blog.BlogVO;
import com.fastcampus.jblog.biz.user.UserVO;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;

	@RequestMapping("/")
	public String index() {
		return "forward:/index.jsp";
	}
	
	@RequestMapping("/getBlogList")
	public String getBlogList(BlogVO vo, HttpSession session) {
		UserVO user = (UserVO) session.getAttribute("user");
		
		if(user.getId() == null) { 
			return "redirect:/";
		}else{
			vo.setUser_id(user.getUser_id());
			
			if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
			if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
			
			session.setAttribute("blogList", blogService.getBlogList(vo));
			return "redirect:/index.jsp";
		}
	}
	
	@RequestMapping("/blogcreateView")
	public String blogcreateView() {
		return "blogcreate";
	}
	
	@RequestMapping("/createBlog")
	public String insertBlog(BlogVO vo, HttpSession session) {
		UserVO user = (UserVO) session.getAttribute("user");
		vo.setUser_id(user.getUser_id());
		blogService.insertBlog(vo);
		return "redirect:/getBlogList";
	}
	
	@RequestMapping("/deleteBlog")
	public String deleteBlog(BlogVO vo) {
		blogService.deleteBlog(vo);
		return "redirect:/getBlogList";
	}

}
