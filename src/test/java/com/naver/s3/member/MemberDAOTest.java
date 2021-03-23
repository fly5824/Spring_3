package com.naver.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.s3.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest {

	@Autowired
	private MemberDAO memberDAO;
	
	
	
	@Test
	public void memberLogin()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId("id14");
		memberDTO.setPw("pw14");
		memberDTO = memberDAO.memberLogIn(memberDTO);
		
		assertNotNull(memberDTO);
		
	}
	
	
//	@Test
//	public void memberJoinTest()throws Exception{
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId("id16");
//		memberDTO.setPw("pw16");
//		memberDTO.setName("id16");
//		memberDTO.setEmail("id16@naver.com");
//		memberDTO.setPhone("1016161616");
//		
//		int result = memberDAO.memberJoin(memberDTO);
//		
//		assertEquals(1, result);
//	}
	
	
	
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
//	
//	@Test
//	public void memberDeleteTest() throws Exception{
//		MemberDTO memberDTO = new MemberDTO();
//		
//		memberDTO.setId("id10");
//		int result = memberDAO.memberDelete(memberDTO);
//		
//		assertEquals(1, result);
//		
//	}
//	
	
	

}
