package com.fastcampus.jblog.biz.blog;

import java.util.List;

public interface BlogService {

	void insertBlog(BlogVO vo);

	void updateBlog(BlogVO vo);

	void deleteBlog(BlogVO vo);

	BlogVO getBlog(BlogVO vo);

	List<BlogVO> getBlogList(BlogVO vo);

}