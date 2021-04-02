package com.naver.s3.board;

import java.util.List;

import com.naver.s3.util.Pager;

public interface BoardDAO {
	
	//상수, 추상메서드
	//접근지정자는 무조건 public abstract
	
	//list
	public List<BoardDTO> getList(Pager pager) throws Exception;

	//전체 글의 갯수
	public long getTotalCount(Pager pager)throws Exception;
	
	//글 조회
	public BoardDTO getSelecct(BoardDTO boardDTO)throws Exception;

	//hit update
	public void setHitUpdate(BoardDTO boardDTO) throws Exception;
	
	//글 추가
	public int setInsert(BoardDTO boardDTO) throws Exception;
	
	//글 수정
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
	//글 삭제
	public int setDelete(BoardDTO boardDTO)throws Exception;





}
