package com.naver.s3.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.s3.board.BoardDTO;
import com.naver.s3.board.BoardService;
import com.naver.s3.util.Pager;
import com.naver.s3.util.Pager_backUp;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<BoardDTO> getList(Pager pager)throws Exception{
		//startRow, lastRow 계산구간============
		pager.makeRow();
		
		//==========페이징계산============================
		long totalCount = noticeDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		//--------------------------------------
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.getSelecct(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setInsert(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}


}
