package com.naver.s3.bankBook;

public class BankBookDTO {
	
	private long bookNumber;
	private String bookName;
	private long bookRate;
	private String bookSale;
	public long getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(long bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public long getBookRate() {
		return bookRate;
	}
	public void setBookRate(long bookRate) {
		this.bookRate = bookRate;
	}
	public String getBookSale() {
		return bookSale;
	}
	public void setBookSale(String bookSale) {
		this.bookSale = bookSale;
	}
	
	
}