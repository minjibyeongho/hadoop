package com.min.quiz09.teacher;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private String TailNum;	//11
	private int CarrierDelay;	//25
	private String ArrDelay;
	final static int NONDELAY= 0;
	
	
	public AirlineParser() {
		
	}
	
	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");
		TailNum = airData[10];
		ArrDelay = airData[14];
	      if(!airData[24].equalsIgnoreCase("NA")) {	//equalsIgnoreCase는 대문자 소문자 구별 없이 분기 해준 것
	    	  CarrierDelay = Integer.parseInt(airData[24]);
	      }else {
	    	  CarrierDelay = -1;
	      }
	}

	public String getArrDelay() {
		return ArrDelay;
	}
	
	
	public String getTailNum() {
		return TailNum;
	}

	public int getCarrierDelay() {
		return CarrierDelay;
	}

	// Map에서 전달되는 데이터 : 항공기 코드, CarrierDelay
	// sum : CarrierDelay 총합
	// avg : 딜레이된 운항횟수, sum
	// 지연율 : 딜레이된 운항 횟수 / 총 운항횟수
	
	
	
}
