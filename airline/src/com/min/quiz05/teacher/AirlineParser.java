package com.min.quiz05.teacher;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int dayofweek;
	private String week;
	
	public AirlineParser() {
		
	}
	
	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");
		this.dayofweek = Integer.parseInt(airData[3]);
	}

	public int getDayofweek() {
		return dayofweek;
	}

	public String getWeek() {
		return week;
	}
	
	
	
	
	
}
