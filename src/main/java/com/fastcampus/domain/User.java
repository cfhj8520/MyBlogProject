package com.fastcampus.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	private String username;
	private String password;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Role role;
}
