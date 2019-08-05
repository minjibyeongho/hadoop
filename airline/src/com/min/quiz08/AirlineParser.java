package com.min.quiz08;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private String UniqueCarrier;
	private int ArrDelay;
	
	public AirlineParser() {
		
	}
	
	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");
		if(!airData[24].equals("NA")){
			this.UniqueCarrier = airData[8];
			this.ArrDelay = Integer.parseInt(airData[24]);
		}
	}

	public String getUniqueCarrier() {
		return UniqueCarrier;
	}

	public int getArrDelay() {
		return ArrDelay;
	}

	
	
}
