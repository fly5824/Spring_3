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
	
	@Test
	public void getSelectTest()throws Exception{
		
		NoticeDTO noticeDTO = noticeDAO.getSelect(null);
				
		assertNotNull(noticeDTO);
	}
	


}
