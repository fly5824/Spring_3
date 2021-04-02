package com.naver.s3.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.s3.board.BoardDTO;
import com.naver.s3.board.BoardService;
import com.naver.s3.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<BoardDTO> getList(Pager pager)throws Exception{
		int perPage=10; //한 페이지당 보여줄 글의 갯수
		int perBlock=5; //한 블럭당 보여줄 숫자의 갯수
		
		//startRow, lastRow 계산구간============
		long startRow =(pager.getCurPage()-1)*perPage+1;
		long lastRow = pager.getCurPage()*perPage;
		
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		
		//======================================
	
		//--------------------------------------
		//1. totalCount
		long totalCount= noticeDAO.getTotalCount(pager);
		//2. totalPage
		long totalPage= totalCount / perPage;
		
		if(totalCount%perPage !=0) {
		 totalPage++;
		}
		//3. totalBlock
		long totalBlock= totalPage/perBlock;
		if(totalPage%5 != 0) {
			totalBlock++;
		}
		//4.curBlock
		long curBlock = pager.getCurPage()/perBlock;
		if(pager.getCurPage()%perBlock!=0) {
			curBlock++;
		}
		
		//5. startNum, lastNum
		long startNum=(curBlock-1)*perBlock+1;
		long lastNum=curBlock*perBlock;
		
		//6. curBlock이 totalBlock일때(=마지막 블럭)
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}
		
		//7. 이전, 다음 block 존재여부
		//이전
		if(curBlock !=1) {
			pager.setPre(true);
		}
		//다음
		if(curBlock !=totalBlock) {
			pager.setNext(true);
		}
		
		pager.setStartNum(startNum);
		pager.setLastNum(lastNum);
	
		System.out.println("TotalPage"+totalPage);
		System.out.println("TotalBlock"+totalBlock);
		System.out.println("curBlock"+curBlock);
		
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
		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}
