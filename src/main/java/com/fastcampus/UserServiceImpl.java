package com.fastcampus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcampus.domain.User;
import com.fastcampus.persistence.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository blogRepository;
	
	public void insertBlog(User user) {
		blogRepository.save(user);
	}
	
	public void updateBlog(User user) {
		User findblog = blogRepository.findById(user.getUsername()).get();
		
		
	}
}
