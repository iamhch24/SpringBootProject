package com.naver.iamhch24.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naver.iamhch24.dao.BalanceDao;
import com.naver.iamhch24.dao.BuyDao;
import com.naver.iamhch24.dao.ProductDao;
import com.naver.iamhch24.dao.VenderDao;
import com.naver.iamhch24.entities.Balance;
import com.naver.iamhch24.entities.Buy;
import com.naver.iamhch24.entities.Product;
import com.naver.iamhch24.entities.Vender;

@Controller
public class DistributionController {

	@Autowired
	Buy buy;

	@Autowired
	private SqlSession sqlSession; // sql 세션화 시킨 클래스 -- 로그인을 하면 그 정보가 연결됨. --> 세션 선언함. (로그인 정보) 다른 페이지에서 정보 사용가능

	@RequestMapping(value = "/balanceInsert", method = RequestMethod.GET)
	public String balanceInsert(Locale locale, HttpSession session) {

		return "distribution/balance_insert";
	}

	@RequestMapping(value = "/balance_insertSave", method = RequestMethod.POST)
	public String balance_insertSave(Locale locale, HttpSession session, @ModelAttribute Balance balance)
			throws Exception {
		System.out.println("/balance_insertSave:: code :: " + balance.getVendcode() + ", " + balance.getYyyy());
		BalanceDao dao = sqlSession.getMapper(BalanceDao.class); // 세션에 매핑
		dao.insertRow(balance);

		return "distribution/balance_insert";
	}

	@RequestMapping(value = "/balanceView", method = RequestMethod.GET)
	public String balanceView(Locale locale, HttpSession session, Model model) throws Exception {
		System.out.println("/balanceView");

		String yyyys[] = new String[5];
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String thisyyyy = year + "";

		int start = year - 2;
		for (int i = 0; i < yyyys.length; i++) {
			yyyys[i] = start++ + "";
		}

		model.addAttribute("years", yyyys);
		model.addAttribute("thisyear", thisyyyy);

		return "distribution/balance_view";
	}

	@RequestMapping(value = "/balanceList", method = RequestMethod.POST)
	public String balanceList(Locale locale, HttpSession session, Model model, @RequestParam String yyyy)
			throws Exception {
		System.out.println("/balanceList");
		BalanceDao dao = sqlSession.getMapper(BalanceDao.class); // 세션에 매핑
		ArrayList<Balance> balances = dao.selectByYear(yyyy);
		model.addAttribute("balances", balances);

		return "distribution/balance_list";
	}

	@RequestMapping(value = "/balanceUpdate", method = RequestMethod.GET)
	public String venderUpdate(Locale locale, HttpSession session, @RequestParam String yyyy,
			@RequestParam String vendcode, Model model) throws Exception {
		System.out.println("/balanceUpdate");

		BalanceDao dao = sqlSession.getMapper(BalanceDao.class); // 세션에 매핑
		HashMap yyyyvend = new HashMap();
		yyyyvend.putIfAbsent("yyyy", yyyy);
		yyyyvend.putIfAbsent("vendcode", vendcode);

		Balance data = dao.selectOne(yyyyvend);

		System.out.println("/balanceUpdate : yyyy =" + data.getYyyy());
		model.addAttribute("balance", data);

		return "distribution/balance_update";
	}

	@RequestMapping(value = "/balance_updateSave", method = RequestMethod.POST)
	public String balance_updateSave(Locale locale, HttpSession session, @ModelAttribute Balance balance)
			throws Exception {
		System.out.println("/balance_updateSave");
		BalanceDao dao = sqlSession.getMapper(BalanceDao.class); // 세션에 매핑
		dao.updateRow(balance);

		return "redirect:balanceList";
	}

	@RequestMapping(value = "/buyInsert", method = RequestMethod.GET)
	public String productInsert(Locale locale, HttpSession session, Model model) throws Exception {
		System.out.println("/buyInsert");
		model = selectDateForCalendar(model);

		ProductDao pdao = sqlSession.getMapper(ProductDao.class); // 세션에 매핑
		ArrayList<Product> products = pdao.selectAll();
		VenderDao vdao = sqlSession.getMapper(VenderDao.class); // 세션에 매핑
		ArrayList<Vender> venders = vdao.selectAll();

		buy.setVendcode("0000");
		buy.setYyyy((String) model.getAttribute("thisyyyy"));
		buy.setMm((String) model.getAttribute("thismm"));
		buy.setDd((String) model.getAttribute("thisdd"));
		model.addAttribute("products", products);
		model.addAttribute("venders", venders);
		model.addAttribute("buy", buy);

		System.out.println("distribution/buy_insert");
		return "distribution/buy_insert";
	}

	@RequestMapping(value = "/productSelectedAjax", method = RequestMethod.POST)
	@ResponseBody
	public Product productSelectedAjax(@RequestParam String code) throws Exception {
		System.out.println("/productSelectedAjax : code = " + code);
		ProductDao dao = sqlSession.getMapper(ProductDao.class); // 세션에 매핑
		Product product = dao.selectOne(code);
		return product;
	}

	@RequestMapping(value = "/buyNew", method = RequestMethod.POST)
	@ResponseBody
	public Buy buyNew(@RequestParam String vendcode) throws Exception {
		System.out.println("vendcode:" + vendcode);
		BuyDao dao = sqlSession.getMapper(BuyDao.class); // 세션에 매핑

		Calendar cal = Calendar.getInstance();
		String thisyyyy = cal.get(Calendar.YEAR) + "";
		String thismm = String.format("%02d", cal.get(Calendar.MONTH) + 1);
		String thisdd = String.format("%02d", cal.get(Calendar.DATE));

		buy.setVendcode(vendcode);
		buy.setYyyy(thisyyyy);
		buy.setMm(thismm);
		buy.setDd(thisdd);
		int no = dao.getMaxNo(buy);
		int hang = 1;
		buy.setNo(no);
		buy.setHang(hang);

		return buy;
	}

	@RequestMapping(value = "/buy_insertSave", method = RequestMethod.POST)
	public String buy_insertSave(Locale locale, HttpSession session, @ModelAttribute Buy buy, Model model)
			throws Exception {
		System.out.println("/buy_insertSave");
		model = selectDateForCalendar(model);

		BuyDao bdao = sqlSession.getMapper(BuyDao.class); // 세션에 매핑
		bdao.insertRow(buy);

		buy.setColumnname("buy" + buy.getMm());
		System.out.println(" columnname : " + buy.getColumnname());

		buy.setDealname("deal" + buy.getMm());
		buy.setBalancename("balance" + buy.getMm());
		BalanceDao baldao = sqlSession.getMapper(BalanceDao.class); // 세션에 매핑
		baldao.buyBalanceAdd(buy);

		ProductDao pdao = sqlSession.getMapper(ProductDao.class); // 세션에 매핑
		pdao.buyProductAdd(buy);
		System.out.println("/buy_insertSave::buyProductAdd");

		VenderDao vdao = sqlSession.getMapper(VenderDao.class); // 세션에 매핑
		ArrayList<Vender> venders = vdao.selectAll();
		model.addAttribute("venders", venders);

		ArrayList<Buy> buyrollups = bdao.selectBuyRollup(buy);
		model.addAttribute("buyrollups", buyrollups);

		int maxhang = bdao.getMaxHang(buy);
		buy.setHang(maxhang);
		model.addAttribute("buy", buy);

		ArrayList<Product> products = pdao.selectAll();
		model.addAttribute("products", products);

		return "distribution/buy_insert";
	}

	@RequestMapping(value = "/buy_updateSave", method = RequestMethod.POST)
	public String buy_updateSave(Locale locale, HttpSession session, @ModelAttribute Buy buy, Model model)
			throws Exception {
		System.out.println("/buy_updateSave");
		model = selectDateForCalendar(model);

		BuyDao bdao = sqlSession.getMapper(BuyDao.class); // 세션에 매핑
		bdao.updateRow(buy);

		VenderDao vdao = sqlSession.getMapper(VenderDao.class); // 세션에 매핑
		ArrayList<Vender> venders = vdao.selectAll();
		model.addAttribute("venders", venders);

		ArrayList<Buy> buyrollups = bdao.selectBuyRollup(buy);
		model.addAttribute("buyrollups", buyrollups);

		int maxhang = bdao.getMaxHang(buy);
		buy.setHang(maxhang);
		model.addAttribute("buy", buy);

		ProductDao pdao = sqlSession.getMapper(ProductDao.class); // 세션에 매핑
		ArrayList<Product> products = pdao.selectAll();
		model.addAttribute("products", products);

		return "distribution/buy_insert";
	}

	@RequestMapping(value = "/buyFind", method = RequestMethod.POST)
	public String buyFind(Locale locale, Model model, @RequestParam String s_vendcode, @RequestParam String s_vendname,
			@RequestParam String s_yyyy, @RequestParam String s_mm, @RequestParam String s_dd) throws Exception {
		System.out.println("find vendcode : " + s_vendcode);
		model = selectDateForCalendar(model);

		model.addAttribute("thisyyyy", s_yyyy);
		model.addAttribute("thismm", s_mm);
		model.addAttribute("thisdd", s_dd);

		ProductDao pdao = sqlSession.getMapper(ProductDao.class); // 세션에 매핑
		ArrayList<Product> products = pdao.selectAll();
		VenderDao vdao = sqlSession.getMapper(VenderDao.class); // 세션에 매핑
		ArrayList<Vender> venders = vdao.selectAll();

		buy.setVendcode(s_vendcode);
		buy.setVendname(s_vendname);
		buy.setYyyy(s_yyyy);
		buy.setMm(s_mm);
		buy.setDd(s_dd);
		BuyDao bdao = sqlSession.getMapper(BuyDao.class); // 세션에 매핑
		ArrayList<Buy> buyrollups = bdao.selectBuyRollup(buy);
		model.addAttribute("buyrollups", buyrollups);

		model.addAttribute("products", products);
		model.addAttribute("venders", venders);
		model.addAttribute("buy", buy);

		System.out.println("distribution/buy_insert :: vendname " + buy.getVendname());
		return "distribution/buy_insert";
	}

	@RequestMapping(value = "/buyRowItemSelectedAjax", method = RequestMethod.POST)
	@ResponseBody
	public Buy buyRowItemSelectedAjax(@RequestParam int seq) throws Exception {
		System.out.println("/buyRowItemSelectedAjax : seq = " + seq);
		BuyDao bdao = sqlSession.getMapper(BuyDao.class); // 세션에 매핑
		Buy buy = bdao.selectOne(seq);

		return buy;
	}

	@RequestMapping(value = "/buyUpdateJsonAjax", method = RequestMethod.POST)
	@ResponseBody
	public Map buyUpdateJsonAjax(@RequestBody Map<String, Object> json) throws Exception {
		System.out.println("/buyUpdateJsonAjax : json.yyyy = " + json.get("yyyy"));
		BuyDao buydao = sqlSession.getMapper(BuyDao.class); // 세션에 매핑

		json.putIfAbsent("columnname", "buy" + json.get("mm"));
		json.putIfAbsent("dealname", "deal" + json.get("mm"));
		json.putIfAbsent("balancename", "balance" + json.get("mm"));
		json.replace("qty", (String) json.get("gty"), (int) Integer.parseInt((String) json.get("qty")));
		json.replace("price", (String) json.get("price"), (int) Integer.parseInt((String) json.get("price")));
		json.replace("beforeqty", (String) json.get("beforeqty"),
				(int) Integer.parseInt((String) json.get("beforeqty")));
		json.replace("beforeprice", (String) json.get("beforeprice"),
				(int) Integer.parseInt((String) json.get("beforeprice")));

		buydao.updateAjax(json);

		System.out.println("----json:" + json.get("columnname"));
		System.out.println("----json:vendname::" + json.get("vendname"));
		System.out.println("----json:vendname::" + URLDecoder.decode((String) json.get("vendname")));

		ProductDao prodao = sqlSession.getMapper(ProductDao.class); // 세션에 매핑
		prodao.buyProductSub(json);
		prodao.buyProductAddJson(json);
		System.out.println("----json: buyProduct Sub / Add");

		BalanceDao baldao = sqlSession.getMapper(BalanceDao.class); // 세션에 매핑
		baldao.buyBalanceSubJson(json);
		baldao.buyBalanceAddJson(json);
		System.out.println("----json: buyBalance Sub / Add");

		return json;
	}

	private Buy JsonDeserializer(Map<String, Object> json) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/buyRowItemDeleteAjax", method = RequestMethod.POST)
	@ResponseBody
	public String buyRowItemDeleteAjax(@RequestParam int seq) throws Exception {
		System.out.println("/buyRowItemDeleteAjax : seq = " + seq);
		BuyDao bdao = sqlSession.getMapper(BuyDao.class); // 세션에 매핑
		String result = bdao.deleteAjax(seq) + "";

		return result;
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