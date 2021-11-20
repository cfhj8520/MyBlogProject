package com.fastcampus;

import com.fastcampus.domain.User;

public interface UserService {

	void insertBlog(User user);

	User getUser(User user);

}