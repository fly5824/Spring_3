package com.naver.s3.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankbookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) throws Exception {
		
		return bankBookDAO.getSelect(bankBookDTO);
	}
	
	public List<BankBookDTO> getList() throws Exception{
		
		return bankBookDAO.getList();
		
	}

	public int setWrite(BankBookDTO bankBookDTO) throws Exception {
		
		int result = bankBookDAO.setWrite(bankBookDTO);
		
		return result;
	}
}
