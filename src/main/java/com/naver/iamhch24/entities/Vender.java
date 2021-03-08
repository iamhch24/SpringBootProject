package com.naver.iamhch24.entities;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Vender {
	private String code; // 거래처 코드 (4)
	private String name; // 상호 (20)
	private String busno1; // 사업자 번호1 (3)
	private String busno2; // 사업자 번호2 (2)
	private String busno3; // 사업자 번호3 (5)
	private String biztype; // 업종형태
	private String ceoname; // 대표자 (20)
	private String zipcode; // 우편번호 (5)
	private String newaddr; // 신주소 (100)
	private String oldaddr; // 구주소 (100)
	private String detailaddr; // 나머지 주소 (50)
	private String officeno1; // 전화번호 1 (3)
	private String officeno2; // 전화번호 2 (4)
	private String officeno3; // 전화번호 3 (4)
}
