package com.naver.iamhch24.entities;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Salary {
	private String empno; // 사원번호
	private String depart; // 부서
	private String name; // 사원이름
	private Integer partner; // 배우자
	private Integer dependent20; // 20세 이하 부양자수
	private Integer dependent60; // 60세 이상 부양자수
	private Integer disabled; // 장애여부
	private Integer womanpower; // 부녀 가장
	private Integer pay; // 월급여
	private Integer extra; // 보너스
	private String yn; // 급여 처리 여부
}
