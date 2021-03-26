package com.naver.s3.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	public List<AccountDTO> getList(AccountDTO accountDTO)throws Exception{
		return accountDAO.getList(accountDTO);
	}
	
	public int setInsert (AccountDTO accountDTO) throws Exception{
		
		return accountDAO.setInsert(accountDTO);
	}
}
