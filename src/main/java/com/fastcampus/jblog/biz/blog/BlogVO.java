package com.fastcampus.jblog.biz.blog;

import lombok.Data;

@Data
public class BlogVO {
	private int blog_id;
	private String title;
	private String tag;
	private int cnt_display_post;
	private String status;
	private int user_id;
	
	private String user_name;
	private String searchCondition;
	private String searchKeyword;
}
