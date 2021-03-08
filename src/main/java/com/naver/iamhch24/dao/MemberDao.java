package com.naver.iamhch24.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.naver.iamhch24.entities.Member;

@Mapper
@Repository
public interface MemberDao {

	public int countAll() throws Exception;
	public void insertRow(Member member) throws Exception;
	public Member selectOne(String email) throws Exception;
	public void updateRow(Member member) throws Exception;
	public ArrayList<Member> selectAll() throws Exception;
	public int updateAjax(Member member) throws Exception;
	public int deleteAjax(String email) throws Exception;
	
//	public int memberAll() throws Exception;
//	public void memberInsert(Member member) throws Exception;
//	public Member memberOne(String email) throws Exception;
//	public void memberUpdate(Member member) throws Exception;
//	public ArrayList<Member> memberList() throws Exception;
//	public int memberLevelUpdate(Member member) throws Exception;
//	public int memberLevelDelete(String email) throws Exception;	
}
