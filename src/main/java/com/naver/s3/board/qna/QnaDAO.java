package com.naver.s3.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.s3.board.BoardDAO;
import com.naver.s3.board.BoardDTO;
import com.naver.s3.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.naver.s3.board.qna.QnaDAO.";
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList",pager);
	}
	@Override
	public long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public BoardDTO getSelecct(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setHitUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"setInsert",boardDTO);
	}
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
	
