package com.fastcampus.persistence;

import org.springframework.data.repository.CrudRepository;

import com.fastcampus.domain.User;

public interface UserRepository extends CrudRepository<User, String>{

}
