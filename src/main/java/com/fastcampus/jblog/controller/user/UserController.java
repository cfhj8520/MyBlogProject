package com.fastcampus.jblog.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.jblog.biz.user.UserService;
import com.fastcampus.jblog.biz.user.UserVO;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/loginView")
	public String loginView() {
		return "bloglogin";
	}
	
	@RequestMapping("/login")
	public String login(UserVO vo, HttpSession session) {
		UserVO user = userService.getUser(vo);
		if(user != null) {
			session.setAttribute("user", user);
			
			return "redirect:/";
		}else {
			return "redirect:/";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
