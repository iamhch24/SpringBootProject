package com.naver.iamhch24.entities;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Member {
	private String email;
	private String name;
	private String password;
	private String oldpassword;
	private String phone;
	private int memlevel;
	private String photo;
	private String oldphoto;
}