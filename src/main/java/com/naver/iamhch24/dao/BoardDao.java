package com.naver.iamhch24.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.naver.iamhch24.entities.Board;
import com.naver.iamhch24.entities.BoardPaging;

@Mapper
@Repository
public interface BoardDao {

	public Integer countAll() throws Exception;

	public void insertRow(Board Board) throws Exception;

	public void insertReplyRow(Board Board) throws Exception;

	public Board selectOne(Integer b_seq) throws Exception;

	public void updateRow(Board Board) throws Exception;

	public ArrayList<Board> selectAll() throws Exception;

	public void updateAjax(Board Board) throws Exception;

	public void deleteAjax(Integer b_seq) throws Exception;

	public void deleteRow(Integer b_seq) throws Exception;

	public ArrayList<Board> selectPageList() throws Exception;

	public Integer selectCount(BoardPaging boardpaging) throws Exception;

	public Integer selectCountFirst() throws Exception;

	public ArrayList<Board> selectPagingList(BoardPaging boardpaging) throws Exception;

	public ArrayList<Board> findListBoard(BoardPaging boardpaging) throws Exception;

	public void addHit(Integer b_seq) throws Exception;

}