package com.naver.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.s3.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest {

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void memberUpdateTest () throws Exception {
		
		memberDTO.setEmail("");
		
		
	}
	

}
