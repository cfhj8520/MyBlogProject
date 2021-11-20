package com.fastcampus.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Blog {
	@Id
	private String username;
	private String password;
	private String name;
	private Role role;
}
