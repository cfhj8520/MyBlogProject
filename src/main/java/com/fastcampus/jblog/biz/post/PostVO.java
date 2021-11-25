package com.fastcampus.jblog.biz.post;

import java.util.Date;

import lombok.Data;

@Data
public class PostVO {
	private int post_id;
	private int category_id;
	private String title;
	private String content;
	private Date date = new Date();
}
