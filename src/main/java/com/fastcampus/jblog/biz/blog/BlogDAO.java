package com.fastcampus.jblog.biz.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fastcampus.jblog.biz.common.JDBCUtil;

@Repository
public class BlogDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private String BLOG_GET = "select * from blog where blog_id = ?";
	private String BLOG_LIST = "select * from blog";
	private String BLOG_INSERT = "insert into blog(blog_id, title, tag, cnt_display_post, status, user_id)" + 
								 "values((select nvl(max(blog_id), 0) + 1 from blog), ?, ?, ?, ?, ?)";
	private String BLOG_UPDATE = "update blog set title = ?, tag = ?, cnt_display_post = ? where blog_id = ?";
	private String BLOG_DELETE = "delete blog where blog_id = ?";
	
	public void insertBlog(BlogVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, "미등록");
			stmt.setInt(3, 3);
			stmt.setString(4, "운영");
			stmt.setInt(5, vo.getUser_id());
			stmt.executeUpdate();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}
	
	public void updateBlog(BlogVO vo) {
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getTag());
			stmt.setInt(3, vo.getCnt_display_post());
			stmt.setInt(4, vo.getBlog_id());
			stmt.executeUpdate();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}
	
	public void deleteBlog(BlogVO vo) {
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_DELETE);
			stmt.setInt(1, vo.getBlog_id());
			stmt.executeUpdate();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}
	
	public BlogVO getBlog(BlogVO vo) {
		BlogVO blog = null;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_GET);
			stmt.setInt(1, vo.getBlog_id());
			rs = stmt.executeQuery();
			if(rs.next()) {
				blog = new BlogVO();
				
				blog.setBlog_id(rs.getInt("BLOG_ID"));
				blog.setTitle(rs.getString("TITLE"));
				blog.setTag(rs.getString("TAG"));
				blog.setCnt_display_post(rs.getInt("CNT_DISPLAY_POST"));
				blog.setStatus(rs.getString("STATUS"));
				blog.setUser_id(rs.getInt("USER_ID"));
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return blog;
	}
	
	public List<BlogVO> getBlogList(BlogVO vo) {
		List<BlogVO> blogList = new ArrayList<BlogVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BlogVO blog = new BlogVO();
				blog.setBlog_id(rs.getInt("BLOG_ID"));
				blog.setTitle(rs.getString("TITLE"));
				blog.setTag(rs.getString("TAG"));
				blog.setCnt_display_post(rs.getInt("CNT_DISPLAY_POST"));
				blog.setStatus(rs.getString("STATUS"));
				blog.setUser_id(rs.getInt("USER_ID"));
				blogList.add(blog);
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return blogList;
	}
}
