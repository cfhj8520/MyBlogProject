package com.fastcampus.jblog.controller.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.jblog.biz.category.CategoryService;
import com.fastcampus.jblog.biz.category.CategoryVO;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/getCategoryList")
	public String getCategoryList(CategoryVO vo, Model model) {
		model.addAttribute("categoryList", categoryService.getCategoryList(vo));
		
		return "blogadmin_category";
	}
	
}
