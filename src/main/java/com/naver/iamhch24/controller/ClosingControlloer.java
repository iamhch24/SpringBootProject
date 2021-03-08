package com.naver.iamhch24.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.naver.iamhch24.dao.BalanceDao;
import com.naver.iamhch24.dao.ProductDao;
import com.naver.iamhch24.entities.Balance;
import com.naver.iamhch24.entities.Buy;

@Controller
public class ClosingControlloer {
	@Autowired
	Buy buy;

	@Autowired
	private SqlSession sqlSession; // sql 세션화 시킨 클래스 -- 로그인을 하면 그 정보가 연결됨. --> 세션 선언함. (로그인 정보) 다른 페이지에서 정보 사용가능

	@RequestMapping(value = "/closingInsert", method = RequestMethod.GET)
	public String balanceInsert(Locale locale, HttpSession session, Model model) {
		model = selectDateForCalendar(model);

		return "closing/closing_insert";
	}

	// 년말 마감은 상품은 현재재고를 전일재고와 전월재고, 전년재고에 넣어주면 끝난다.
	// 현재 잔액이 다음해의 전년이월과 1월잔액, 잔액으로 들어가야 함.
	// 화면의 년도가 다음해로 넘어가게 처리
	@RequestMapping(value = "/yyyyClosing", method = RequestMethod.POST)
	public String yyyyClosing(Model model, @RequestParam String yyyy) throws Exception {
		model = selectDateForCalendar(model);
		System.out.println("/yyyyClosing: ");
		ProductDao prodao = sqlSession.getMapper(ProductDao.class); // 세션에 매핑
		prodao.yyProductClosing();

		BalanceDao baldao = sqlSession.getMapper(BalanceDao.class); // 세션에 매핑

		ArrayList<Balance> balances = baldao.selectByYear(yyyy);
//		for (Balance balance : balances) {
//			System.out.println("->yyyy: " + balance.getYyyy() + ", newyyyy: " + balance.getNewyyyy());
//		}

//		baldao.yyBalanceClosing(balances);
		baldao.yyBalanceClosing2(yyyy);
		return "closing/closing_insert";
	}

	// 월말 마감은 상품은 현재재고를 전일재고와 전월재고에 넣어주면 끝난다.
	// 현재 잔액이 다음달의 이월과 잔액으로 들어가야 함.
	@RequestMapping(value = "/mmClosing", method = RequestMethod.POST)
	public String mmClosing(Model model, @RequestParam String yyyy, @RequestParam String mm) throws Exception {
		model = selectDateForCalendar(model);
		System.out.println("/mmClosing: ");
		ProductDao prodao = sqlSession.getMapper(ProductDao.class); // 세션에 매핑
		prodao.mmProductClosing();

		String nextmm = String.format("%02d", Integer.parseInt(mm) + 1);

		HashMap hash = new HashMap();
		hash.put("columnpre", "prebalance" + nextmm);
		hash.put("columnbalance", "balance" + nextmm);
		hash.put("yyyy", yyyy);

		BalanceDao baldao = sqlSession.getMapper(BalanceDao.class); // 세션에 매핑
		baldao.mmBalanceClosing(hash);

		return "closing/closing_insert";
	}

	// 일일 마감은 상품만 해주면 된다. 상품 재고 현재 재고를 전일 재고에 넣어주면 된다.
	@RequestMapping(value = "/ddClosing", method = RequestMethod.POST)
	public String ddClosing(Locale locale, HttpSession session, Model model) throws Exception {
		model = selectDateForCalendar(model);
		System.out.println("/ddClosing: ");
		ProductDao prodao = sqlSession.getMapper(ProductDao.class); // 세션에 매핑
		prodao.ddProductClosing();
		return "closing/closing_insert";
	}

	private Model selectDateForCalendar(Model model) {

		String yyyys[] = new String[5];
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		int start = year - 2;
		for (int i = 0; i < yyyys.length; i++) {
			yyyys[i] = start++ + "";
		}

		String mms[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		String dds[] = new String[31];
		for (int i = 0; i < dds.length; i++) {
			dds[i] = String.format("%02d", i + 1);
		}

		String thisyyyy = year + "";
		String thismm = String.format("%02d", cal.get(Calendar.MONTH) + 1);
		String thisdd = String.format("%02d", cal.get(Calendar.DATE));

		model.addAttribute("yyyys", yyyys);
		model.addAttribute("mms", mms);
		model.addAttribute("dds", dds);
		model.addAttribute("thisyyyy", thisyyyy);
		model.addAttribute("thismm", thismm);
		model.addAttribute("thisdd", thisdd);

		return model;
	}

}
