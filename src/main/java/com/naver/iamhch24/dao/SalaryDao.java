package com.naver.iamhch24.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.naver.iamhch24.entities.Salary;
import com.naver.iamhch24.entities.SalaryRoll;
import com.naver.iamhch24.entities.SalaryRollViewToBean;

@Mapper
@Repository
public interface SalaryDao {

	public Integer countAll() throws Exception;

	public ArrayList<Salary> selectAll() throws Exception;

	public ArrayList<Salary> selectTaxYes() throws Exception;

	public Salary selectOne(String empno) throws Exception;

	public void insertRow(Salary salary) throws Exception;

	public void updateRow(Salary salary) throws Exception;

	public void deleteRow(String empno) throws Exception;

	public int updateAjax(Salary salary) throws Exception;

	public int deleteAjax(String empno) throws Exception;

	public void insertSalaryRoll(SalaryRoll salaryroll) throws Exception;

	public ArrayList<SalaryRollViewToBean> selectSalaryRollView(HashMap yyyymm) throws Exception;

	public void deleteSalaryRollbefore(HashMap yyyymm) throws Exception;

}