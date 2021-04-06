package com.naver.s3.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.s3.board.BoardDTO;
import com.naver.s3.board.BoardService;
import com.naver.s3.util.Pager;
import com.naver.s3.util.Pager_backUp;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO QnaDAO;

	public int setReply(QnaDTO qnaDTO) throws Exception{
		//부모글의 ref, step, depth 값 조회해야함
		BoardDTO boardDTO = QnaDAO.getSelecct(qnaDTO);
		QnaDTO parent = (QnaDTO)boardDTO;
		System.out.println(parent.getRef());
		System.out.println(parent.getStep());
		System.out.println(parent.getDepth());
		
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		int result = QnaDAO.setReplyUpdate(parent);
		result = QnaDAO.setReply(qnaDTO);
		
		return result;
	}
	
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		//1. row
		pager.makeRow();
		//2.pageing
		long totalCount = QnaDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		return QnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		int result = QnaDAO.setHitUpdate(boardDTO);
		return QnaDAO.getSelecct(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return QnaDAO.setInsert(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return QnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return QnaDAO.setDelete(boardDTO);
	}
	
}