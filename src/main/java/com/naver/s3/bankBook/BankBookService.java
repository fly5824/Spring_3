package com.naver.s3.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.s3.util.Pager_backUp;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;

	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setUpdate(bankBookDTO);
		
	}
	
	
	
	public List<BankBookDTO> getList(Pager_backUp pager) throws Exception{
		int perPage= 10;
		int perBlock=5;
		
		long totalCount= 202;
		long totalPage= totalCount/perPage;
		if(totalPage%perPage !=0) {
			totalPage++;
		}
		long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			totalBlock++;
		}
		
		return bankBookDAO.getList(pager);
		
	}
	
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) throws Exception{
		
		return bankBookDAO.getSelect(bankBookDTO);
	}
	
	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		
		return bankBookDAO.setDelete(bankBookDTO);
	}
}
