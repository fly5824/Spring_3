package com.naver.s3.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.s3.MyAbstractTest;

public class NoticeDAOTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void getListTest()throws Exception{
//		
//		List<NoticeDTO> ar = noticeDAO.getList();
//		
//		assertNotEquals(0, ar.size());
//	}
	
//	@Test
//	public void getSelectTest()throws Exception{
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setNum(1);
//		noticeDTO = noticeDAO.getSelect(noticeDTO);
//				
//		assertNotNull(noticeDTO);
//	}
	
//	@Test
//	public void setInsertTest()throws Exception{
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setContents("석희석희지윤");
//		noticeDTO.setHit(30);
//		noticeDTO.setTitle("석희와지윤이");
//		noticeDTO.setWriter("admin");
//		
//		int result = noticeDAO.setInsert(noticeDTO);
//		
//		assertEquals(1, result);
//	}
//	
//	@Test
//	public void setDeleteTest()throws Exception{
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setNum(1);
//		int result = noticeDAO.setDelete(noticeDTO);
//		
//		assertEquals(1, result);
//	}
	@Test
	public void setUpdate()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(2);
		noticeDTO.setTitle("업데이트타이틀");
		noticeDTO.setContents("업데이트 컨텐츠");
		
		int result = noticeDAO.setUpdate(noticeDTO);
		
		assertEquals(1, result);
	}

	

}
