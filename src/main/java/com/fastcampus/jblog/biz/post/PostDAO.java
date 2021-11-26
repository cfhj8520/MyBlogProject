package com.fastcampus.jblog.biz.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fastcampus.jblog.biz.blog.BlogVO;
import com.fastcampus.jblog.biz.common.JDBCUtil;

@Repository
public class PostDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private String POST_INSERT = "insert into post(post_id, category_id, title, content, created_date) "
								+"values((select nvl(max(post_id), 0) + 1 from post), ?, ?, ?, ?)";
	private String POST_UPDATE = "update post set title = ?, category_id = ?, content = ? where post_id = ?";
	private String POST_DELETE = "delete from post where post_id = ?";
	private String POST_GET = "select * from post where post_id = ?";
	private String POST_GETLIST_CATEGORY = "select * from post where category_id = ? order by post_id desc";
	private String POST_GETLIST_BLOG = "select p.post_id, p.category_id, p.title, p.content, p.created_date from post p, category c where c.category_id = p.category_id and c.blog_id = ? order by post_id desc";
	
	public void insertPost(PostVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(POST_INSERT);
			stmt.setInt(1, vo.getCategory_id());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getContent());
			stmt.setDate(4, new java.sql.Date(vo.getCreated_date().getTime()));
			stmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void updatePost(PostVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(POST_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setInt(2, vo.getCategory_id());
			stmt.setString(3, vo.getContent());
			stmt.setInt(4, vo.getPost_id());
			stmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void deletePost(PostVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(POST_DELETE);
			stmt.setInt(1, vo.getPost_id());
			stmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public PostVO getPost(PostVO vo) {
		PostVO post = null;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(POST_GET);
			stmt.setInt(1, vo.getPost_id());
			rs = stmt.executeQuery();
			if(rs.next()) {
				post = new PostVO();
				
				post.setPost_id(rs.getInt("POST_ID"));
				post.setCategory_id(rs.getInt("CATEGORY_ID"));
				post.setTitle(rs.getString("TITLE"));
				post.setContent(rs.getString("CONTENT"));
				post.setCreated_date(rs.getDate("CREATED_DATE"));
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return post;
	}
	
	public List<PostVO> getPostList(PostVO vo) {
		List<PostVO> postList = new ArrayList<PostVO>();
		try {
			conn = JDBCUtil.getConnection();
			
			if(vo.getCategory_id() == 0) {
				stmt = conn.prepareStatement(POST_GETLIST_BLOG);
				stmt.setInt(1, vo.getBlog_id());
			}else {
				stmt = conn.prepareStatement(POST_GETLIST_CATEGORY);
				stmt.setInt(1, vo.getCategory_id());
			}
			rs = stmt.executeQuery();
			while(rs.next()) {
				PostVO post = new PostVO();
				post.setPost_id(rs.getInt("POST_ID"));
				post.setCategory_id(rs.getInt("CATEGORY_ID"));
				post.setTitle(rs.getString("TITLE"));
				post.setContent(rs.getString("CONTENT"));
				post.setCreated_date(rs.getDate("CREATED_DATE"));
				postList.add(post);
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return postList;
	}
}
