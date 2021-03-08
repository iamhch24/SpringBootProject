package com.naver.iamhch24.entities;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Closing {
	private String newyyyy;
	private String yyyy;
	private String vendcode;
	private String vendname;
	private int preyybalance; // 전년 이월 잔액
	private int prebalance01; // 1월 이월 잔액
	private int prebalance02;
	private int prebalance03;
	private int prebalance04;
	private int prebalance05;
	private int prebalance06;
	private int prebalance07;
	private int prebalance08;
	private int prebalance09;
	private int prebalance10;
	private int prebalance11;
	private int prebalance12;
	private int deal01; // 1월 거래금액
	private int deal02;
	private int deal03;
	private int deal04;
	private int deal05;
	private int deal06;
	private int deal07;
	private int deal08;
	private int deal09;
	private int deal10;
	private int deal11;
	private int deal12;
	private int pay01; // 1월 결재 금액
	private int pay02;
	private int pay03;
	private int pay04;
	private int pay05;
	private int pay06;
	private int pay07;
	private int pay08;
	private int pay09;
	private int pay10;
	private int pay11;
	private int pay12;
	private int balance01; // 1월 잔액
	private int balance02;
	private int balance03;
	private int balance04;
	private int balance05;
	private int balance06;
	private int balance07;
	private int balance08;
	private int balance09;
	private int balance10;
	private int balance11;
	private int balance12;
	private int balance; // 현재 잔액
	private int paytot; // 결재 총액
	private int dealtot; // 거래 총액
}
