package com.naver.iamhch24.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naver.iamhch24.dao.ProductDao;
import com.naver.iamhch24.dao.VenderDao;
import com.naver.iamhch24.entities.Product;
import com.naver.iamhch24.entities.Vender;

@Controller
public class ProductController {

	@Autowired
	Product product;

	@Autowired
	private SqlSession sqlSession; // sql 세션화 시킨 클래스 -- 로그인을 하면 그 정보가 연결됨. --> 세션 선언함. (로그인 정보) 다른 페이지에서 정보 사용가능

	@RequestMapping(value = "/productInsert", method = RequestMethod.GET)
	public String productInsert(Locale locale, HttpSession session) {

		return "product/product_insert";
	}

	@RequestMapping(value = "/codeConfirmAjax", method = RequestMethod.POST)
	@ResponseBody
	public String codeConfirmAjax(@RequestParam String code) throws Exception {
		System.out.println("/codeConfirmAjax");
		ProductDao dao = sqlSession.getMapper(ProductDao.class); // 세션에 매핑
		Product data = dao.selectOne(code);
		String row = "yes";
		if (data == null) {
			row = "no";
		} else {
			System.out.println("-->ajax 호출 : " + data.getName());
		}
		return row;
	}

	@RequestMapping(value = "/product_insertSave", method = RequestMethod.POST)
	public String product_insertSave(Locale locale, HttpSession session, @ModelAttribute Product product)
			throws Exception {
		System.out.println("/product_insertSave:: code :: " + product.getCode());
		ProductDao dao = sqlSession.getMapper(ProductDao.class); // 세션에 매핑
		dao.insertRow(product);

		return "product/product_insert";
	}

	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public String productList(Locale locale, HttpSession session, Model model) throws Exception {
		System.out.println("/productList");
		ProductDao dao = sqlSession.getMapper(ProductDao.class); // 세션에 매핑
		ArrayList<Product> products = dao.selectAll();
		model.addAttribute("products", products);
		return "product/product_list";
	}

	@RequestMapping(value = "/productUpdate", method = RequestMethod.GET)
	public String productUpdate(Locale locale, HttpSession session, @RequestParam String code, Model model)
			throws Exception {
		System.out.println("/productUpdate");
		ProductDao dao = sqlSession.getMapper(ProductDao.class); // 세션에 매핑
		Product product = dao.selectOne(code);
		model.addAttribute("product", product);

		return "product/product_update";
	}

	@RequestMapping(value = "/product_updateSave", method = RequestMethod.POST)
	public String productUpdate(Locale locale, HttpSession session, @ModelAttribute Product product) throws Exception {
		System.out.println("/product_updateSave");
		ProductDao dao = sqlSession.getMapper(ProductDao.class); // 세션에 매핑
		dao.updateRow(product);

		return "redirect:productList";
	}

	@RequestMapping(value = "/venderInsert", method = RequestMethod.GET)
	public String venderInsert(Locale locale, HttpSession session) {

		return "product/vender_insert";
	}

	@RequestMapping(value = "/venderCodeConfirmAjax", method = RequestMethod.POST)
	@ResponseBody
	public String venderCodeConfirmAjax(@RequestParam String code) throws Exception {
		System.out.println("/venderCodeConfirmAjax");
		VenderDao dao = sqlSession.getMapper(VenderDao.class); // 세션에 매핑
		Vender data = dao.selectOne(code);
		String row = "yes";
		if (data == null) {
			row = "no";
		} else {
			System.out.println("-->ajax 호출 : " + data.getName());
		}
		return row;
	}

	@RequestMapping(value = "/vender_insertSave", method = RequestMethod.POST)
	public String vender_insertSave(Locale locale, HttpSession session, @ModelAttribute Vender vender)
			throws Exception {
		System.out.println("/vender_insertSave:: code :: " + vender.getCode());
		VenderDao dao = sqlSession.getMapper(VenderDao.class); // 세션에 매핑
		dao.insertRow(vender);

		return "product/vender_insert";
	}

	@RequestMapping(value = "/venderList", method = RequestMethod.GET)
	public String venderList(Locale locale, HttpSession session, Model model) throws Exception {
		System.out.println("/venderList");
		VenderDao dao = sqlSession.getMapper(VenderDao.class); // 세션에 매핑
		ArrayList<Vender> venders = dao.selectAll();
		model.addAttribute("venders", venders);

		return "product/vender_list";
	}

	@RequestMapping(value = "/venderUpdate", method = RequestMethod.GET)
	public String venderUpdate(Locale locale, HttpSession session, @RequestParam String code, Model model)
			throws Exception {
		System.out.println("/venderUpdate");

		VenderDao dao = sqlSession.getMapper(VenderDao.class); // 세션에 매핑
		Vender data = dao.selectOne(code);

		System.out.println("/venderUpdate : code =" + data.getCode());
		model.addAttribute("vender", data);
		return "product/vender_update";
	}

	@RequestMapping(value = "/vender_updateSave", method = RequestMethod.POST)
	public String vender_updateSave(Locale locale, HttpSession session, @ModelAttribute Vender vender)
			throws Exception {
		System.out.println("/vender_updateSave");
		VenderDao dao = sqlSession.getMapper(VenderDao.class); // 세션에 매핑
		dao.updateRow(vender);

		return "redirect:venderList";
	}

}
