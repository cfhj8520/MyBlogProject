package com.fastcampus.jblog.biz.category;

import java.util.Date;

import lombok.Data;

@Data
public class CategoryVO {
	private int blog_id;
	private int category_id;
	private String category_name;
	private String display_type;
	private int cnt_display_post;
	private String description;
	private Date created_date;
	private Date modified_date;
}
