package com.naver.iamhch24.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.iamhch24.dao.MemberDao;
import com.naver.iamhch24.entities.Member;

@Service
public class MemberService implements MemberDao{
	
	@Autowired
	MemberDao memberdao;

	@Override
	public int countAll() throws Exception {
		// TODO Auto-generated method stub
		return memberdao.countAll();
	}

	@Override
	public void insertRow(Member member) throws Exception {
		// TODO Auto-generated method stub
		memberdao.insertRow(member);
	}

	@Override
	public Member selectOne(String email) throws Exception {
		// TODO Auto-generated method stub
		return memberdao.selectOne(email);
	}

	@Override
	public void updateRow(Member member) throws Exception {
		// TODO Auto-generated method stub
		memberdao.updateRow(member);
	}

	@Override
	public ArrayList<Member> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return memberdao.selectAll();
	}

	@Override
	public int updateAjax(Member member) throws Exception {
		// TODO Auto-generated method stub
		return memberdao.updateAjax(member);
	}

	@Override
	public int deleteAjax(String email) throws Exception {
		// TODO Auto-generated method stub
		return memberdao.deleteAjax(email);
	}



}