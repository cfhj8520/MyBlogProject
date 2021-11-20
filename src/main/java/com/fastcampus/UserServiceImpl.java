package com.fastcampus;

import java.util.Optional;

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
	
	public User getUser(User user) {
		Optional<User> optional = blogRepository.findById(user.getUsername());
		
		if(!optional.isEmpty()) {
			return optional.get();
		}else {
			return null;
		}
	}
}
