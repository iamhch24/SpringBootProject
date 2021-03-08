package com.naver.iamhch24.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.naver.iamhch24.entities.Buy;
import com.naver.iamhch24.entities.Product;

@Mapper
@Repository
public interface ProductDao {

	public int countAll() throws Exception;

	public void insertRow(Product product) throws Exception;

	public Product selectOne(String code) throws Exception;

	public void updateRow(Product product) throws Exception;

	public ArrayList<Product> selectAll() throws Exception;

	public int updateAjax(Product product) throws Exception;

	public int deleteAjax(String code) throws Exception;

	public int buyProductAdd(Buy buy) throws Exception;

	public int buyProductSub(Map json) throws Exception;

	public int buyProductAddJson(Map json) throws Exception;

	public int ddProductClosing() throws Exception;

	public int mmProductClosing() throws Exception;

	public int yyProductClosing() throws Exception;

}
