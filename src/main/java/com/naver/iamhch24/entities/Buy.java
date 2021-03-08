package com.naver.iamhch24.entities;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Buy {
	private int seq;
	private String vendcode;
	private String vendname;
	private String yyyy;
	private String mm;
	private String dd;
	private int no;
	private int hang;
	private String procode;
	private String beforeprocode;
	private String proname;
	private int price;
	private int beforeprice;
	private int qty;
	private int beforeqty;
	private int total;
	private int beforetotal;
	private String memo;
	private String columnname;
	private String dealname;
	private String balancename;
}
