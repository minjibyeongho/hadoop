package com.min.quiz07.teacher;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int date;
	private int cancelled;
	
	public AirlineParser() {
		
	}
	
	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");
		this.date = Integer.parseInt(airData[2]);
		this.cancelled = Integer.parseInt(airData[21]);
	}

	public int getDate() {
		return date;
	}

	public int getCancelled() {
		return cancelled;
	}
}
