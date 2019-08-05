package com.min.quiz08.teacher;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private String UniqueCarrier;
	private int carrierDealy;
	
	final static int SUSPENSIONOFAIRLINNE=-1;
	final int NONAIRFLIGHT=0;
	
	public AirlineParser() {
		
	}
	
	public AirlineParser(Text value) {
		//연착된값
		
		String[] airData = value.toString().split(",");
		
		// 조건이 한개 일 경우에는 {}를 표시하지 않아도무방하다
		if("NA".equalsIgnoreCase(airData[24]))
		//if(airData[24].toUpperCase().equals("NA")){
			this.carrierDealy = SUSPENSIONOFAIRLINNE;
		else
			this.carrierDealy = Integer.parseInt(airData[24]);
			this.UniqueCarrier = airData[8];
		
	}

	public String getUniqueCarrier() {
		return UniqueCarrier;
	}

	public int getCarrierDealy() {
		return carrierDealy;
	}


	
	
}
