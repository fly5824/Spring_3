package com.naver.s3.account;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.s3.MyAbstractTest;

public class AccountDAOTest extends MyAbstractTest{

	@Autowired
	private AccountDAO accountDAO;
	
//	@Test
//	public void getList() throws Exception{
//		AccountDTO accountDTO = new AccountDTO();
//		accountDTO.setId("id1");
//		List<AccountDTO> ar = accountDAO.getList(accountDTO);
//		
//		assertNotEquals(0, ar.size());
//	}
	
	@Test
	public void setInsert()throws Exception{
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId("iu");
		accountDTO.setAccountBalance(33);
		accountDTO.setAccountNumber("123-456-7");
		accountDTO.setBookNumber(2);
		
		
	}

}
