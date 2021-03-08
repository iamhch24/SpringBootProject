package com.naver.iamhch24.entities;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class SalaryRollViewToBean {
	private String yyyy;
	private String mm;
	private String empno;
	private String depart;
	private String name;
	private int partner;
	private int dependent20;
	private int dependent60;
	private int disabled;
	private int womanpower;
	private int mmpay;
	private int insurance;
	private int tax;
	private int residence;
	private int lastamount;
}
