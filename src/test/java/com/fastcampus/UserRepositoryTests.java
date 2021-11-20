package com.fastcampus;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fastcampus.domain.Role;
import com.fastcampus.domain.User;
import com.fastcampus.persistence.UserRepository;

@SpringBootTest
class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	void testGetUser() {	
		User user = new User();
		user.setUsername("test");
		user.setPassword("test123");
		user.setRole(Role.ADMIN);
		user.setName("둘리");
		userRepository.save(user);

		assertNotNull(userRepository.findById("test"));
	}

}
