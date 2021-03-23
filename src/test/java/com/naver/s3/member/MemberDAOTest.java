package com.naver.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.s3.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest {

	@Autowired
	private MemberDAO memberDAO;
	
//	@Test
//	public void memberUpdateTest () throws Exception {
//		MemberDTO memberDTO = new MemberDTO();
//		
//		memberDTO.setId("id10");
//		memberDTO.setEmail("hihi@naver.com");
//		memberDTO.setName("hihi");
//		memberDTO.setPhone("01022334455");
//		memberDTO.setPw("hihi");
//		
//		int result = memberDAO.memberUpdate(memberDTO);
//		
//		assertEquals(1, result);
//		
//	}
	
	@Test
	public void memberDeleteTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId("id10");
		int result = memberDAO.memberDelete(memberDTO);
		
		
	}
	
	
	

}
