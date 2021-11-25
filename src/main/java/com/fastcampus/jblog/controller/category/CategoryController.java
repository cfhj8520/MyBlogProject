package com.fastcampus.jblog.controller.category;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.jblog.biz.blog.BlogService;
import com.fastcampus.jblog.biz.blog.BlogVO;
import com.fastcampus.jblog.biz.category.CategoryService;
import com.fastcampus.jblog.biz.category.CategoryVO;
import com.fastcampus.jblog.biz.user.UserVO;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/getCategoryList")
	public String getCategoryList(HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("user");
		BlogVO blog = new BlogVO();
		CategoryVO category = new CategoryVO();
		
		category.setBlog_id(user.getUser_id());
		blog.setUser_id(user.getUser_id());
		
		model.addAttribute("categoryList", categoryService.getCategoryList(category));
		model.addAttribute("blog", blogService.getBlog(blog));
		
		return "blogadmin_category";
	}
	
	@RequestMapping("/createCategory")
	public String createCategory(CategoryVO vo, HttpSession session) {
		UserVO user = (UserVO) session.getAttribute("user");
		vo.setBlog_id(user.getUser_id());
		categoryService.insertCategory(vo);
		
		return "redirect:/getCategoryList";
	}
}
