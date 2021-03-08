package com.naver.iamhch24.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naver.iamhch24.entities.Member;
import com.naver.iamhch24.service.MemberService;

@Controller
public class HomeController {

	@Autowired
	MemberService memservice;

	@RequestMapping(value = "/")
	public String home(Model model, Locale locale, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {

		String curlang = (String) session.getAttribute("lang");
		if (curlang == null || curlang.equals("")) {
			session.setAttribute("lang", "kr");
			locale = Locale.KOREAN;
		}

		try {
			String admin = "admin@a.com";
			Member data = memservice.selectOne(admin);
			System.out.println("----success:" + data.getEmail());

		} catch (Exception e) {
			System.out.println("-------------fail..." + e.getMessage());
		}
		return "index";
	}

	@RequestMapping(value = "/index")
	public String index(Model model, Locale locale, HttpSession session) {
		return "index";
	}

	@RequestMapping(value = "/languageAjax")
	@ResponseBody
	public String languageAjax(Locale locale, @RequestParam String lang, HttpSession session) {
		session.setAttribute("lang", lang);
		locale = Locale.ENGLISH;
		return (String) session.getAttribute("lang");
	}

	@RequestMapping(value = "/inputSample", method = RequestMethod.GET)
	public String inputSample(Model model, Locale locale, HttpSession session) {
		System.out.println("==inputSample==");
		return "sample/inputform_sample";
	}

	@RequestMapping(value = "/dataTableSample", method = RequestMethod.GET)
	public String dataTableSample(Model model, Locale locale, HttpSession session) {
		System.out.println("==dataTableSample==");
		return "sample/datatable_sample";
	}

}