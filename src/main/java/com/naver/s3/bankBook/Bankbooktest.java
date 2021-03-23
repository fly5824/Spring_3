package com.naver.s3.bankBook;

public class Bankbooktest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
		
		try {
			
			bankBookDTO.setBookName("zzzz");
			bankBookDTO.setBookRate(2);
			bankBookDTO.setBookSale("y");
			
			int result = bankBookDAO.setWrite(bankBookDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
