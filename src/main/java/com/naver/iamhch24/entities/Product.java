package com.naver.iamhch24.entities;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Product {
	private String code; // 상품코드 13 primary key
	private String name; // 상품명 30
	private String capacity;// 규격 30
	private int buyprice; // 매입단가 9(11)
	private int saleprice; // 매출단가 9(11)
	private int preyystock; // 전년재고 9(7)
	private int premmstock; // 전월재고 9(7)
	private int preddstock; // 전일재고 9(7)
	private int buy01; // 1월 매입 9(7)
	private int buy02;
	private int buy03;
	private int buy04;
	private int buy05;
	private int buy06;
	private int buy07;
	private int buy08;
	private int buy09;
	private int buy10;
	private int buy11;
	private int buy12;
	private int sale01; // 1월 매출
	private int sale02;
	private int sale03;
	private int sale04;
	private int sale05;
	private int sale06;
	private int sale07;
	private int sale08;
	private int sale09;
	private int sale10;
	private int sale11;
	private int sale12;
	private int stock; // 핸재 재고
	private String explanation; // 상품 설명 50
}
