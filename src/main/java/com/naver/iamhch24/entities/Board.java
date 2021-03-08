package com.naver.iamhch24.entities;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Board {
	private int b_seq;
	private int b_ref;
	private int b_step;
	private String b_email;
	private String b_name;
	private String b_title;
	private String b_content;
	private int b_hit;
	private String b_attach;
	private String b_inputtime;
	private String b_inputip;
}
