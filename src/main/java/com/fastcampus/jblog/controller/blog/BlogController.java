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
	public String index() {
		return "forward:/index.jsp";
	}
	
	@RequestMapping("/getBlogList")
	public String getBlogList(UserVO vo, HttpSession session) {
		UserVO user = (UserVO) session.getAttribute("user");
		System.out.println(user);
		
		if(user.getId() == null) { 
			System.out.println("실패");
			return "redirect:/";
		}else{
			BlogVO blog = new BlogVO();
			blog.setUser_id(user.getUser_id());
			
			session.setAttribute("blogList", blogService.getBlogList(blog));
			System.out.println("성공");
			return "forward:/index.jsp";
		}
	}
	
	@RequestMapping("/blogcreateView")
	public String insertBlog(BlogVO vo) {
		return "blogcreate";
	}

}
