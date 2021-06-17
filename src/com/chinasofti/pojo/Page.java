package com.chinasofti.pojo;

public class Page {
	private int cur;
	private int size=5;
	private int total;
	private int start;
	
	public int getStart() {
		start=(cur-1)*size;
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public Page() {
	
	}
	public int getCur() {
		return cur;
	}
	public void setCur(int cur) {
		this.cur = cur;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
