package com.fastcampus.jblog.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

	@RequestMapping("/")
	public String index() {
		return "forward:/index.jsp";
	}
}
