package com.naver.s3.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;

	
	public List<BankBookDTO> getList() throws Exception{
		
		return bankBookDAO.getList();
		
	}
	
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) throws Exception{
		
		return bankBookDAO.getSelect(bankBookDTO);
	}
}