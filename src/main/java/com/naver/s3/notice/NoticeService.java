package com.naver.s3.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.s3.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> getList(Pager pager)throws Exception{
		int perPage=10; //한 페이지당 보여줄 글의 갯수
		
		//startRow, lastRow 계산구간============
		long startRow =(pager.getCurPage()-1)*perPage+1;
		long lastRow = pager.getCurPage()*perPage;
		
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		
		//======================================
	
		//--------------------------------------
		long totalCount=123;
		long totalPage= totalCount / perPage;
		
		if(totalCount%perPage !=0) {
		 totalPage++;
		}
		
		pager.setTotalPage(totalPage);
		return noticeDAO.getList(pager);
	}

	public NoticeDTO getSelect(NoticeDTO noticeDTO)throws Exception{
		
		return noticeDAO.getSelect(noticeDTO);
	}
	
	public int setInsert(NoticeDTO noticeDTO)throws Exception{
		
		return noticeDAO.setInsert(noticeDTO);
	}
	
	public int setUpdate(NoticeDTO noticeDTO)throws Exception{
		
		return noticeDAO.setUpdate(noticeDTO);
	}
	
	public int setDelete(NoticeDTO noticeDTO)throws Exception{
		
		return noticeDAO.setDelete(noticeDTO);
	}
}
