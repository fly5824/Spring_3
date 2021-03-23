package com.naver.s3.bankBook;

public class BankBookDTO {
	
	private int bookNumber;
	private String bookName;
	private int bookRate;
	private String bookSale;
	
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookRate() {
		return bookRate;
	}
	public void setBookRate(int bookRate) {
		this.bookRate = bookRate;
	}
	public String getBookSale() {
		return bookSale;
	}
	public void setBookSale(String bookSale) {
		this.bookSale = bookSale;
	}
	
	
	
}