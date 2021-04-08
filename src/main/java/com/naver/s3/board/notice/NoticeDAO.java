package com.naver.s3.board.notice;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.s3.board.BoardDAO;
import com.naver.s3.board.BoardDTO;
import com.naver.s3.board.BoardFileDTO;
import com.naver.s3.util.Pager;
import com.naver.s3.util.Pager_backUp;

@Repository
public class NoticeDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.naver.s3.board.notice.NoticeDAO";
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".getList", pager);
	}
	@Override
	public long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".getTotalCount",pager);
	}
	@Override
	public BoardDTO getSelecct(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".getSelect", boardDTO);
	}
	@Override
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+".setInsert",boardDTO);
	}
	
	public long getNum()throws Exception{
		return sqlSession.selectOne(NAMESPACE+".getNum");
	}
	
	public int setFileInsert(BoardFileDTO boardFileDTO)throws Exception{
		
		return sqlSession.insert(NAMESPACE+".setFileInsert",boardFileDTO);
		
	}
	
	
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+".setUpdate",boardDTO);
	}
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+".setDelete",boardDTO);
	}
	
	
}

