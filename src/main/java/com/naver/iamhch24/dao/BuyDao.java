package com.naver.iamhch24.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.naver.iamhch24.entities.Buy;

@Mapper
@Repository
public interface BuyDao {

	public int countAll() throws Exception;

	public void insertRow(Buy buy) throws Exception;

	public Buy selectOne(int seq) throws Exception;

	public void updateRow(Buy buy) throws Exception;

	public ArrayList<Buy> selectAll() throws Exception;

	public ArrayList<Buy> selectBuyRollup(Buy buy) throws Exception;

	public ArrayList<Buy> selectBuyFindRollup(Model model) throws Exception;

	public ArrayList<Buy> selectByYear(String yyyy) throws Exception;

	public int updateAjax(Map<String, Object> json) throws Exception;

	public int deleteAjax(int seq) throws Exception;

	public int getMaxNo(Buy buy) throws Exception;

	public int getMaxHang(Buy buy) throws Exception;

}
