package com.naver.iamhch24.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.naver.iamhch24.entities.Vender;

@Mapper
@Repository
public interface VenderDao {

	public int countAll() throws Exception;

	public void insertRow(Vender vender) throws Exception;

	public Vender selectOne(String code) throws Exception;

	public void updateRow(Vender vender) throws Exception;

	public ArrayList<Vender> selectAll() throws Exception;

	public int updateAjax(Vender vender) throws Exception;

	public int deleteAjax(String code) throws Exception;

}
