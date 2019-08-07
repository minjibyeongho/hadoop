package com.min.ex01;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	// 9, 11, 25
	private String UniqueCarrier_min;
	private String TailNum_min;
	private int CarrierDelay_min;
	
	public static final int NONDELAY = 0;
	
	public AirlineParser() {	}
	
	private int getDigitFromStr(String str, int defaultDigit){
		if("NA".equalsIgnoreCase(str)) return defaultDigit;
		//else else가 없어도 위에 if에 해당하면 return하며 종료되기 때문에
			return Integer.parseInt(str);
	}
	
	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");
		
		UniqueCarrier_min = airData[8];
		TailNum_min = airData[10];
		CarrierDelay_min = getDigitFromStr(airData[24], NONDELAY);
	}

	public String getUniqueCarrier_min() {
		return UniqueCarrier_min;
	}

	public void setUniqueCarrier_min(String uniqueCarrier_min) {
		UniqueCarrier_min = uniqueCarrier_min;
	}

	public String getTailNum_min() {
		return TailNum_min;
	}

	public void setTailNum_min(String tailNum_min) {
		TailNum_min = tailNum_min;
	}

	public int getCarrierDelay_min() {
		return CarrierDelay_min;
	}

	public void setCarrierDelay_min(int carrierDelay_min) {
		CarrierDelay_min = carrierDelay_min;
	}
	
	
	
}
