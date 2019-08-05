package com.min.quiz09;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private String TailNum;	//11
	private int CarrierDelay;	//25
	
	
	
	public AirlineParser() {
		
	}
	
	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");
		// csv파일에서 NA는 운항을 안한 데이터(내 풀이는 NA를 0으로 치환하여 운항횟수를 센 것으로 풀이)
		TailNum = airData[10];
	      if(airData[24].equalsIgnoreCase("NA")) {
	    	  CarrierDelay = Integer.parseInt(airData[24]);
	      }else {
	    	  CarrierDelay = 0;
	      }
	}

	

	public String getTailNum() {
		return TailNum;
	}

	public int getCarrierDelay() {
		return CarrierDelay;
	}

	
	
	
}
