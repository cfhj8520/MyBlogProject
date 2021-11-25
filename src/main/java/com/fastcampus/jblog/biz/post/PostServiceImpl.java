package com.fastcampus.jblog.biz.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostService postService;
	
	@Override
	public void insertPost(PostVO vo) {
		postService.insertPost(vo);
	}

	@Override
	public void updatePost(PostVO vo) {
		postService.updatePost(vo);
	}

	@Override
	public void deletePost(PostVO vo) {
		postService.deletePost(vo);
	}

	@Override
	public PostVO getPost(PostVO vo) {
		return postService.getPost(vo);
	}

	@Override
	public List<PostVO> getPostList(PostVO vo) {
		return postService.getPostList(vo);
	}

}
