package com.naver.s3.util;

public class Pager {
	
	private long curPage;
	public long getCurPage() {
		if(this.curPage<1) {
			this.curPage =1;
		}
		return curPage;
	}
	public void setCurPage(long curPage) {
		if(curPage<1) {
				curPage =1;}
		this.curPage = curPage;
	}
	private long startRow;
	private long lastRow;
	private long totalPage;
	
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public long getStartRow() {
		return startRow;
	}
	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}
	public long getLastRow() {
		return lastRow;
	}
	public void setLastRow(long lastRow) {
		this.lastRow = lastRow;
	}
	
	

}
