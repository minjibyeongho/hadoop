package com.min.Ex07.teacher;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	// 둘다 int로 처리해도 되나 강의 목적상 String과 int 2가지 sort방식을 배우기 위해 year는 String / month는 int로
	private String year;
	private int month;
	private int cancelled;
	
	final int NONCANCELLED = 0;
	
	public AirlineParser() {}
	public AirlineParser(Text txt) {
		String []airData = txt.toString().split(",");
		year = airData[0];
		month = Integer.parseInt(airData[1]);
		cancelled = Integer.parseInt(airData[21]);
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setCancelled(int cancelled) {
		this.cancelled = cancelled;
	}
	public String getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getCancelled() {
		return cancelled;
	}
}
