package com.fastcampus.persistence;

import org.springframework.data.repository.CrudRepository;

import com.fastcampus.domain.Blog;

public interface BlogRepository extends CrudRepository<Blog, String>{

}
