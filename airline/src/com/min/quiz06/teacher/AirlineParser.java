package com.min.quiz06.teacher;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int year;
	private int month;
	private int dayOfWeek;
	private int cancelled;
	
	final int CANCELLED = 1;
	
	public AirlineParser() {
		
	}
	
	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");
		this.year = Integer.parseInt(airData[0]);
		this.month = Integer.parseInt(airData[1]);
		this.cancelled = Integer.parseInt(airData[21]);
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getCancelled() {
		return cancelled;
	}
	
	
	
	
}
