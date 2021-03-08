package com.naver.iamhch24.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.naver.iamhch24.entities.Balance;
import com.naver.iamhch24.entities.Buy;

@Mapper
@Repository
public interface BalanceDao {

	public int countAll() throws Exception;

	public void insertRow(Balance balance) throws Exception;

	public Balance selectOne(HashMap yyyyvend) throws Exception;

	public void updateRow(Balance balance) throws Exception;

	public ArrayList<Balance> selectAll() throws Exception;

	public ArrayList<Balance> selectByYear(String yyyy) throws Exception;

	public int updateAjax(Balance balance) throws Exception;

	public int deleteAjax(String code) throws Exception;

	public int buyBalanceAdd(Buy buy) throws Exception;

	public int buyBalanceAddJson(Map json) throws Exception;

	public int buyBalanceSub(Buy buy) throws Exception;

	public int buyBalanceSubJson(Map json) throws Exception;

	public void mmBalanceClosing(HashMap hash) throws Exception;

	public void yyBalanceClosing(ArrayList<Balance> balances) throws Exception;

	public void yyBalanceClosing2(String yyyy) throws Exception;

}
