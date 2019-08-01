package com.min.quiz05;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int week1;
	private String week;
	
	public AirlineParser() {
		
	}
	
	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");
		this.week1 = Integer.parseInt(airData[3]);
		
		if(week1 == 1){
			week = "월 요 일";
		}else if(week1 == 2){
			week = "화 요 일";
		}else if(week1 == 3){
			week = "수 요 일";
		}else if(week1 == 4){
			week = "목 요 일";
		}else if(week1 == 5){
			week = "금 요 일";
		}else if(week1 == 6){
			week = "토 요 일";
		}else{
			week = "일 요 일";
		}
		
	}

	public int getWeek1() {
		return week1;
	}

	public String getWeek() {
		return week;
	}
	
	
	
	
}
