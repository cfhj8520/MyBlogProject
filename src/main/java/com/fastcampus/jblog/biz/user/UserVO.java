package com.fastcampus.jblog.biz.user;

import lombok.Data;

@Data
public class UserVO {
	private int user_id;			//회원 일련번호
	private String id;			//회원 아이디
	private String password;
	private String user_name;
	private String role;
}
