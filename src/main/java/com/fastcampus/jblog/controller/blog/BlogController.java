package com.fastcampus.jblog.controller.blog;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.jblog.biz.blog.BlogService;
import com.fastcampus.jblog.biz.blog.BlogVO;
import com.fastcampus.jblog.biz.user.UserVO;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;

	@RequestMapping("/")
	public String index(HttpSession session) {
		UserVO user = (UserVO) session.getAttribute("user");
		
		if(user != null) {
			BlogVO blog = new BlogVO();
			blog.setUser_id(user.getUser_id());
			
			if(blogService.getBlog(blog) != null)
				session.setAttribute("hasBlog", true);
			else
				session.setAttribute("hasBlog", false);
		}
		
		return "forward:/index.jsp";
	}
	
	@RequestMapping("/getBlogList")
	public String getBlogList(BlogVO vo, HttpSession session) {
		UserVO user = (UserVO) session.getAttribute("user");
		
		if(user == null) { 
			if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
			if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
			
			session.setAttribute("blogList", blogService.getBlogList(vo));
			
			return "redirect:/";
		}else{
			if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
			if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
			
			session.setAttribute("blogList", blogService.getBlogList(vo));
			return "redirect:/";
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
	
	@RequestMapping("/blogmainView")
	public String blogmainView() {
		return "blogmain";
	}

	@RequestMapping("/blogadmin_basicView")
	public String blogadmin_basicView(BlogVO vo, HttpSession session) {
		BlogVO blog = blogService.getBlog(vo);
		
		if(blog != null) {
			session.setAttribute("blog", blog);
			
			return "blogadmin_basic";
		}else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("/updateBlog")
	public String updateBlog(BlogVO vo, HttpSession session) {
		BlogVO blog = (BlogVO) session.getAttribute("blog");
		blog.setBlog_id(blog.getUser_id());
		blog.setTitle(vo.getTitle());
		blog.setTag(vo.getTag());
		blog.setStatus(vo.getStatus());
		blog.setCnt_display_post(vo.getCnt_display_post());
		blogService.updateBlog(blog);
		
		return "redirect:/blogmainView";
	}
	
	@RequestMapping("/blogDeleteReq")
	public String blogDeleteReq(HttpSession session) {
		BlogVO blog = blogService.getBlog((BlogVO) session.getAttribute("blog"));
		blog.setStatus("삭제요청");
		System.out.println(blog);
		blogService.updateBlog(blog);
		
		return "redirect:/";
	}
}
