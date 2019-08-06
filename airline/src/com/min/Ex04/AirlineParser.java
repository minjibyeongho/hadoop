package com.min.Ex04;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int arrDelay;
	private int depDelay;
	private int cancelled;
	private String UniqueCarrier;
	private int distance;
	
	private int Month;
	private int WeatherDelay;
	
	final int CANCELLED = 1;
	final int NONAIRFLIGHT = 0;
	final static int SUSPENSIONOFAIRLINNE= -1;
	final static int NONDELAY= 0;
	
	public AirlineParser() {	}
	
	private int getDigitFromStr(String str, int defaultDigit){
		if("NA".equalsIgnoreCase(str)) return defaultDigit;
		//else else가 없어도 위에 if에 해당하면 return하며 종료되기 때문에
			return Integer.parseInt(str);
	}
	
	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");
		
		distance = Integer.parseInt(airData[18]);
		
		UniqueCarrier = airData[8];
		//2 : 월
		//26 : 기상악화로 인한 악화
		
		arrDelay = getDigitFromStr(airData[14], NONDELAY);
		depDelay = getDigitFromStr(airData[15], NONDELAY);
		
		if(!"NA".equalsIgnoreCase(airData[25])){	//NA값을 거르고(0 포함 양수 존재)
			Month = Integer.parseInt(airData[1]);
			WeatherDelay = Integer.parseInt(airData[25]);
		}
		
		cancelled = Integer.parseInt(airData[21]);
	}

	public int getMonth() {
		return Month;
	}

	public int getWeatherDelay() {
		return WeatherDelay;
	}

	public int getDistance() {
		return distance;
	}

	public String getUniqueCarrier() {
		return UniqueCarrier;
	}

	public int getArrDelay() {
		return arrDelay;
	}

	public int getDepDelay() {
		return depDelay;
	}

	public int getCancelled() {
		return cancelled;
	}
}
