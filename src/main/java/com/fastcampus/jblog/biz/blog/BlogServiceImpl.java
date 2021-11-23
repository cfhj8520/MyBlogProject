package com.fastcampus.jblog.biz.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogDAO blogDAO;

	@Override
	public void insertBlog(BlogVO vo) {
		blogDAO.insertBlog(vo);
	}

	@Override
	public void updateBlog(BlogVO vo) {
		blogDAO.updateBlog(vo);
	}

	@Override
	public void deleteBlog(BlogVO vo) {
		blogDAO.deleteBlog(vo);
	}

	@Override
	public BlogVO getBlog(BlogVO vo) {
		return blogDAO.getBlog(vo);
	}

	@Override
	public List<BlogVO> getBlogList(BlogVO vo) {
		return blogDAO.getBlogList(vo);
	}

}
