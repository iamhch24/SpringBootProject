package com.naver.iamhch24.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.iamhch24.dao.BoardDao;
import com.naver.iamhch24.entities.Board;
import com.naver.iamhch24.entities.BoardPaging;

@Service
public class BoardService implements BoardDao {

	@Autowired
	BoardDao boarddao;

	@Override
	public Integer countAll() throws Exception {
		// TODO Auto-generated method stub
		return boarddao.countAll();
	}

	@Override
	public void insertRow(Board Board) throws Exception {
		// TODO Auto-generated method stub
		boarddao.insertRow(Board);
	}

	@Override
	public Board selectOne(Integer b_seq) throws Exception {
		// TODO Auto-generated method stub
		return boarddao.selectOne(b_seq);
	}

	@Override
	public void updateRow(Board Board) throws Exception {
		// TODO Auto-generated method stub
		boarddao.updateRow(Board);
	}

	@Override
	public ArrayList<Board> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return boarddao.selectAll();
	}

	@Override
	public void updateAjax(Board Board) throws Exception {
		// TODO Auto-generated method stub
		boarddao.updateAjax(Board);
	}

	@Override
	public void deleteAjax(Integer b_seq) throws Exception {
		// TODO Auto-generated method stub
		boarddao.deleteAjax(b_seq);
	}

	@Override
	public ArrayList<Board> selectPageList() throws Exception {
		// TODO Auto-generated method stub
		return boarddao.selectPageList();
	}

	@Override
	public Integer selectCount(BoardPaging boardpaging) throws Exception {
		// TODO Auto-generated method stub
		return boarddao.selectCount(boardpaging);
	}

	@Override
	public ArrayList<Board> selectPagingList(BoardPaging boardpaging) throws Exception {
		// TODO Auto-generated method stub
		return boarddao.selectPagingList(boardpaging);
	}

	@Override
	public ArrayList<Board> findListBoard(BoardPaging boardpaging) throws Exception {
		// TODO Auto-generated method stub
		return boarddao.findListBoard(boardpaging);
	}

	@Override
	public Integer selectCountFirst() throws Exception {
		// TODO Auto-generated method stub
		return boarddao.selectCountFirst();
	}

	@Override
	public void addHit(Integer b_seq) throws Exception {
		// TODO Auto-generated method stub
		boarddao.addHit(b_seq);
	}

	@Override
	public void insertReplyRow(Board Board) throws Exception {
		// TODO Auto-generated method stub
		boarddao.insertReplyRow(Board);
	}

	@Override
	public void deleteRow(Integer b_seq) throws Exception {
		// TODO Auto-generated method stub
		boarddao.deleteRow(b_seq);
	}

}