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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naver.iamhch24.dao.SalaryDao;
import com.naver.iamhch24.entities.Salary;
import com.naver.iamhch24.entities.SalaryRoll;
import com.naver.iamhch24.entities.SalaryRollViewToBean;

@Controller
public class SalaryController {

	@Autowired
	Salary salary;

	@Autowired
	SalaryRoll salaryroll;

	@Autowired
	private SqlSession sqlSession; // sql 세션화 시킨 클래스 -- 로그인을 하면 그 정보가 연결됨. --> 세션 선언함. (로그인 정보) 다른 페이지에서 정보 사용가능

	@RequestMapping(value = "/empnoConfirmAjax", method = RequestMethod.POST)
	@ResponseBody
	public String empnoConfirmAjax(@RequestParam String empno) throws Exception {
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class); // 세션에 매핑
		Salary data = dao.selectOne(empno);
		String row = "yes";
		if (data == null) {
			row = "no";
		} else {
			System.out.println("-->ajax 호출 : " + data.getName());
		}
		return row;
	}

	@RequestMapping(value = "/salaryUpdate", method = RequestMethod.GET)
	public String salaryUpdate(Model model, @RequestParam String empno) throws Exception {

//		System.out.println(empno);
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class); // 세션에 매핑
		Salary salary = dao.selectOne(empno);
		model.addAttribute("salary", salary);

		return "salary/salary_update";
	}

	@RequestMapping(value = "/salary_updateSave", method = RequestMethod.POST)
	public String salary_updateSave(Model model, @ModelAttribute Salary salary) throws Exception {
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class); // 세션에 매핑
		dao.updateRow(salary);
		return "redirect:salaryList";
	}

	@RequestMapping(value = "/salaryUpdateAjax", method = RequestMethod.POST)
	@ResponseBody
	public String memberUpdateAjax(@RequestParam String empno, @RequestParam String yn) throws Exception {
		salary.setEmpno(empno);
		salary.setYn(yn);
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class); // 세션에 매핑
		int result = dao.updateAjax(salary);
		if (result > 0) {
			return "Y";
		} else {
			return "N";
		}
	}

	@RequestMapping(value = "/salaryDeleteAjax", method = RequestMethod.POST)
	@ResponseBody
	public String memberDeleteAjax(@RequestParam String empno) throws Exception {
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class); // 세션에 매핑
		int result = dao.deleteAjax(empno);
		if (result > 0) {
			return "Y";
		} else {
			return "N";
		}
	}

	@RequestMapping(value = "/salaryInsert", method = RequestMethod.GET)
	public String salaryInsert(Locale locale, HttpSession session) {
		return "salary/salary_insert";
	}

	@RequestMapping(value = "/salary_insertSave", method = RequestMethod.POST)
	public String salary_insertSave(Locale locale, HttpSession session, @ModelAttribute Salary salary)
			throws Exception {
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class); // 세션에 매핑
		dao.insertRow(salary);
		return "index";
	}

	@RequestMapping(value = "/salaryList", method = RequestMethod.GET)
	public String salaryList(Locale locale, Model model) throws Exception {
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class); // 세션에 매핑
		ArrayList<Salary> salarys = dao.selectAll();
		model.addAttribute("salarys", salarys);
		return "salary/salary_list";
	}

	@RequestMapping(value = "/salaryCreateTax", method = RequestMethod.GET)
	public String salaryCreateTax(Locale locale, Model model) throws Exception {

//		System.out.println("== /salaryCreateTax ==");

		String yyyys[] = new String[5];
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		int start = year - 2;
		for (int i = 0; i < yyyys.length; i++) {
			yyyys[i] = start++ + "";
		}

		String mms[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		model.addAttribute("years", yyyys);
		model.addAttribute("months", mms);
		String thisyyyy = year + "";

		String thismm = String.format("%02d", cal.get(Calendar.MONTH) + 1);
		model.addAttribute("thisyear", thisyyyy);
		model.addAttribute("thismonth", thismm);

//		System.out.println("== salary/salary_tax == thismonth " + thismm);
		return "salary/salary_tax";
	}

	@RequestMapping(value = "/salaryTaxRun", method = RequestMethod.POST)
	public String salaryTaxRun(@RequestParam String yyyy, @RequestParam String mm) throws Exception {

		System.out.println("== /salaryTaxRun == yyyy = " + yyyy + ", mm = " + mm);

//		SalaryDao dao = sqlSession.getMapper(SalaryDao.class); // 세션에 매핑
//		ArrayList<Salary> salarys = dao.selectAll();
//		model.addAttribute("salarys", salarys);
		return "index";
	}

	@RequestMapping(value = "/salaryTaxCalculate", method = RequestMethod.POST)
	public String salaryTaxCalculate(@RequestParam String yyyy, @RequestParam String mm) throws Exception {

		System.out.println("== /salaryTaxCalculate == yyyy = " + yyyy + ", mm = " + mm);
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class); // 세션에 매핑
		ArrayList<Salary> salarys = dao.selectTaxYes();

		HashMap yyyymm = new HashMap();
		yyyymm.putIfAbsent("yyyy", yyyy);
		yyyymm.putIfAbsent("mm", mm);
		dao.deleteSalaryRollbefore(yyyymm);

		for (Salary salary : salarys) {
			salaryroll.setYyyy(yyyy);
			salaryroll.setMm(mm);
			salaryroll.setEmpno(salary.getEmpno());
			salaryroll.setDepart(salary.getDepart());
			salaryroll.setName(salary.getName());

			salaryroll.setPartner(salary.getPartner() * 1500000);
			salaryroll.setDependent20(salary.getDependent20() * 1500000);
			salaryroll.setDependent60(salary.getDependent60() * 1500000);
			salaryroll.setDisabled(salary.getDisabled() * 1500000);
			salaryroll.setPay12(salary.getPay() * 12);

			int family = 1 + salary.getPartner() + salary.getDependent20() + salary.getDependent60()
					+ salary.getDisabled();
			int pay12 = (salary.getPay() + salary.getExtra()) * 12;
			int incomededuction = 0;
			if (family == 1) {
				if (pay12 <= 30000000) {
					incomededuction = (int) (3100000 + (pay12 * 0.04));
				} else if (pay12 > 30000000 && pay12 <= 45000000) {
					incomededuction = (int) (3100000 + (pay12 * 0.04) - ((pay12 - 30000000) * 0.05));
				} else if (pay12 > 45000000 && pay12 <= 70000000) {
					incomededuction = (int) (3100000 + (pay12 * 0.015));
				} else if (pay12 > 70000000 && pay12 <= 120000000) {
					incomededuction = (int) (3100000 + (pay12 * 0.005));
				}
			} else if (family == 2) {
				if (pay12 <= 30000000) {
					incomededuction = (int) (3600000 + (pay12 * 0.04));
				} else if (pay12 > 30000000 && pay12 <= 45000000) {
					incomededuction = (int) (3600000 + (pay12 * 0.04) - ((pay12 - 30000000) * 0.05));
				} else if (pay12 > 45000000 && pay12 <= 70000000) {
					incomededuction = (int) (3600000 + (pay12 * 0.02));
				} else if (pay12 > 70000000 && pay12 <= 120000000) {
					incomededuction = (int) (3600000 + (pay12 * 0.01));
				}
			} else {
				if (pay12 <= 30000000) {
					incomededuction = (int) (5000000 + (pay12 * 0.07));
				} else if (pay12 > 30000000 && pay12 <= 45000000) {
					incomededuction = (int) (5000000 + (pay12 * 0.07) - ((pay12 - 30000000) * 0.05));
				} else if (pay12 > 45000000 && pay12 <= 70000000) {
					incomededuction = (int) (5000000 + (pay12 * 0.05));
				} else if (pay12 > 70000000 && pay12 <= 120000000) {
					incomededuction = (int) (5000000 + (pay12 * 0.03));
				}

				if (pay12 > 40000000) {
					incomededuction = (int) (incomededuction + ((pay12 - 40000000) * 0.04));
				}

			}
			salaryroll.setIncomededuction(incomededuction);
			salaryroll.setIncomeamount(pay12 - incomededuction);
			salaryroll.setPersonaldeduction(family * 1500000);
			int annuityinsurance = (int) ((pay12 / 12 * 0.045) * 12);
			salaryroll.setAnnuityinsurance(annuityinsurance);
			int standardamount = pay12 - (incomededuction + family * 1500000 + annuityinsurance);
			salaryroll.setStandardamount(standardamount);
			int calculatedtax = 0;
			if (standardamount <= 12000000) {
				calculatedtax = (int) (standardamount * 0.06);
			} else if (standardamount > 12000000 && standardamount <= 46000000) {
				calculatedtax = 720000 + (int) ((standardamount - 12000000) * 0.15);
			} else if (standardamount > 46000000 && standardamount <= 88000000) {
				calculatedtax = 5820000 + (int) ((standardamount - 46000000) * 0.24);
			} else if (standardamount > 88000000 && standardamount <= 150000000) {
				calculatedtax = 15900000 + (int) ((standardamount - 88000000) * 0.35);
			} else if (standardamount > 150000000 && standardamount <= 300000000) {
				calculatedtax = 37600000 + (int) ((standardamount - 150000000) * 0.38);
			} else if (standardamount > 300000000 && standardamount <= 500000000) {
				calculatedtax = 94600000 + (int) ((standardamount - 300000000) * 0.40);
			} else if (standardamount > 500000000) {
				calculatedtax = 174600000 + (int) ((standardamount - 500000000) * 0.42);
			}
			salaryroll.setCalculatedtax(calculatedtax);
			int incometaxdeduction = 0;
			if (calculatedtax < 1300000) {
				incometaxdeduction = (int) (calculatedtax * 0.55);
			} else {
				incometaxdeduction = 715000 + (int) ((calculatedtax - 1300000) * 0.30);
			}

			if (pay12 <= 33000000 && incometaxdeduction > 740000) {
				incometaxdeduction = 740000;
			} else if (pay12 > 37000000 && pay12 <= 70000000) {
				if (incometaxdeduction > 740000 - (int) ((pay12 - 33000000) * 0.008)) {
					incometaxdeduction = 740000 - (int) ((pay12 - 33000000) * 0.008);
				}
				if (incometaxdeduction < 660000) {
					incometaxdeduction = 660000;
				}
			} else if (pay12 > 70000000) {
				if (incometaxdeduction > 660000 - (int) ((pay12 - 70000000) * 0.5)) {
					incometaxdeduction = 660000 - (int) ((pay12 - 70000000) * 0.5);
				}
				if (incometaxdeduction < 500000) {
					incometaxdeduction = 500000;
				}
			}
			salaryroll.setIncometaxdeduction(incometaxdeduction);
			int decidedtax = calculatedtax - incometaxdeduction;
			salaryroll.setDecidedtax(decidedtax);
			int simpletax = (int) ((decidedtax / 12) * 0.01);
			simpletax = simpletax * 100;
			salaryroll.setSimpletax(simpletax);
			int finalpay = salary.getPay() + salary.getExtra() - (annuityinsurance / 12 + simpletax);
			salaryroll.setFinalpay(finalpay);

//			System.out.println("== /salaryTaxCalculate == pay " + salary.getPay());
//			System.out.println("== /salaryTaxCalculate == extra " + salary.getExtra());
//			System.out.println("== /salaryTaxCalculate == pay12 " + pay12);
//			System.out.println("== /salaryTaxCalculate == standardamount " + standardamount);
//			System.out.println("== /salaryTaxCalculate == calculatedtax " + calculatedtax);
//			System.out.println("== /salaryTaxCalculate == decidedtax " + decidedtax);
//			System.out.println("== /salaryTaxCalculate == simpletax " + simpletax);
//			System.out.println("== /salaryTaxCalculate == annuityinsurance " + annuityinsurance);
//			System.out.println("== /salaryTaxCalculate == finalpay " + finalpay);

			dao.insertSalaryRoll(salaryroll);
		}
		return "redirect:salaryCreateTax";
	}

	@RequestMapping(value = "/salaryTaxDelete", method = RequestMethod.POST)
	public String salaryTaxDelete(@RequestParam String yyyy, @RequestParam String mm) throws Exception {

		System.out.println("== /salaryTaxDelete == yyyy = " + yyyy + ", mm = " + mm);
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class); // 세션에 매핑
		HashMap yyyymm = new HashMap();
		yyyymm.putIfAbsent("yyyy", yyyy);
		yyyymm.putIfAbsent("mm", mm);
		dao.deleteSalaryRollbefore(yyyymm);

		return "redirect:salaryCreateTax";
	}

	@RequestMapping(value = "/salaryRollList", method = RequestMethod.GET)
	public String salaryRollList(Locale locale, Model model, HttpSession session) throws Exception {

//		System.out.println("== /salaryRollList ==");
		String yyyys[] = new String[5];
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		int start = year - 2;
		for (int i = 0; i < yyyys.length; i++) {
			yyyys[i] = start++ + "";
		}

		String mms[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		model.addAttribute("years", yyyys);
		model.addAttribute("months", mms);
		String thisyyyy = year + "";

		String thismm = String.format("%02d", cal.get(Calendar.MONTH) + 1);
		model.addAttribute("thisyear", thisyyyy);
		model.addAttribute("thismonth", thismm);

		return "salary/salaryroll_list";
	}

	@RequestMapping(value = "/salaryRollView", method = RequestMethod.POST)
	public String salaryRollView(Model model, @RequestParam String yyyy, @RequestParam String mm) throws Exception {

//		System.out.println("== /salaryRollView == yyyy = " + yyyy + ", mm = " + mm);
		SalaryDao dao = sqlSession.getMapper(SalaryDao.class); // 세션에 매핑
		HashMap yyyymm = new HashMap();
		yyyymm.putIfAbsent("yyyy", yyyy);
		yyyymm.putIfAbsent("mm", mm);
		ArrayList<SalaryRollViewToBean> salaryrolls = dao.selectSalaryRollView(yyyymm);
		model.addAttribute("salaryrolls", salaryrolls);

		return "salary/salaryroll_viewlist";
	}
}