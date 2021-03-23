package com.naver.s3.bankbook;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.s3.MyAbstractTest;
import com.naver.s3.bankBook.BankBookDAO;
import com.naver.s3.bankBook.BankBookDTO;


public class BankBookDAOTest extends MyAbstractTest {

	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void getSelectTest() throws Exception {
		BankBookDTO bankBookDTO = bankBookDAO.getSelect(null);
		assertNotNull(bankBookDTO);
	}
	
//	@Test
//	public void setWriteTest() throws Exception {
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		
//		bankBookDTO.setBookName("Test");
//		bankBookDTO.setBookRate(11);
//		bankBookDTO.setBookSale("y");
//			
//		int result = bankBookDAO.setWrite(bankBookDTO);
//		
//		assertEquals(1, result);

	} 


