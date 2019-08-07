package com.min.Ex07.v2;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	/*private int arrDelay;
	private int depDelay;
	private int cancelled;
	private String UniqueCarrier;
	private int distance;
	private int ActualElapsedTi;
	private int CRSElapsedTime;
	private String TailNum;
	private String FlightNum;
	
	private int Month;
	private int WeatherDelay;
	
	final int CANCELLED = 1;
	final int NONAIRFLIGHT = 0;
	final static int SUSPENSIONOFAIRLINNE= -1;
	final static int NONDELAY= 0;*/
	
	private int Year;
	private int Month;
	
	public AirlineParser() {	}
	
	/*private int getDigitFromStr(String str, int defaultDigit){
		if("NA".equalsIgnoreCase(str)) return defaultDigit;
		//else else가 없어도 위에 if에 해당하면 return하며 종료되기 때문에
			return Integer.parseInt(str);
	}*/
	
	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");
		
		Year = Integer.parseInt(airData[0]);
		Month = Integer.parseInt(airData[1]);
	}

	public int getYear() {
		return Year;
	}

	public int getMonth() {
		return Month;
	}
	
	
	
}
