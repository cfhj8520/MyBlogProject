package com.fastcampus.jblog.biz.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fastcampus.jblog.biz.common.JDBCUtil;

@Repository
public class CategoryDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private String CATEGORY_INSERT = "insert into category(blog_id, category_id, category_name, display_type, cnt_display_post, description, created_date) "
								   + "values(?, (select nvl(max(category_id), 0) + 1 from category), ?, ?, ?, ? , ?)";
	private String CATEGORY_UPDATE = "update category set category_name = ?, display_type = ?, cnt_display_post = ?, description = ?, modified_date = ? where category_id = ?";
	private String CATEGORY_DELETE = "delete from category where category_id = ?";
	private String CATEGORY_GET = "select * from category where category_id = ?";
	private String CATEGORY_GETLIST = "select * from category where blog_id = ?";
	
	public void insertCategory(CategoryVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CATEGORY_INSERT);
			stmt.setInt(1, vo.getBlog_id());
			stmt.setString(2, vo.getCategory_name());
			stmt.setString(3, vo.getDisplay_type());
			stmt.setInt(4, vo.getCnt_display_post());
			stmt.setString(5, vo.getDescription());
			stmt.setDate(6, new java.sql.Date(vo.getCreated_date().getTime()));
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void updateCategory(CategoryVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CATEGORY_UPDATE);
			stmt.setString(1, vo.getCategory_name());
			stmt.setString(2, vo.getDisplay_type());
			stmt.setInt(3, vo.getCnt_display_post());
			stmt.setString(4, vo.getDescription());
			stmt.setDate(5, new java.sql.Date(vo.getModified_date().getTime()));
			stmt.setInt(6, vo.getCategory_id());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void deleteCategory(CategoryVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CATEGORY_DELETE);
			stmt.setInt(1, vo.getCategory_id());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public CategoryVO getCategory(CategoryVO vo) {
		CategoryVO category = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CATEGORY_GET);
			stmt.setInt(1, vo.getCategory_id());
			rs = stmt.executeQuery();
			if(rs.next()) {
				category = new CategoryVO();
				category.setBlog_id(rs.getInt("BLOG_ID"));
				category.setCategory_id(rs.getInt("CATEGORY_ID"));
				category.setCategory_name(rs.getString("CATEGORY_NAME"));
				category.setDisplay_type(rs.getString("DISPLAY_TYPE"));
				category.setCnt_display_post(rs.getInt("CNT_DISPLAY_POST"));
				category.setDescription(rs.getString("DESCRIPTION"));
				category.setCreated_date(rs.getDate("CREATED_DATE"));
				category.setModified_date(rs.getDate("MODIFIED_DATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return category;
	}
	
	public List<CategoryVO> getCategoryList(CategoryVO vo) {
		List<CategoryVO> categoryList = new ArrayList<CategoryVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CATEGORY_GETLIST);
			stmt.setInt(1, vo.getBlog_id());
			rs = stmt.executeQuery();
			while(rs.next()) {
				CategoryVO category = new CategoryVO();
				category.setBlog_id(rs.getInt("BLOG_ID"));
				category.setCategory_id(rs.getInt("CATEGORY_ID"));
				category.setCategory_name(rs.getString("CATEGORY_NAME"));
				category.setDisplay_type(rs.getString("DISPLAY_TYPE"));
				category.setCnt_display_post(rs.getInt("CNT_DISPLAY_POST"));
				category.setDescription(rs.getString("DESCRIPTION"));
				category.setCreated_date(rs.getDate("CREATED_DATE"));
				category.setModified_date(rs.getDate("MODIFIED_DATE"));
				categoryList.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return categoryList;
	}
	
}
