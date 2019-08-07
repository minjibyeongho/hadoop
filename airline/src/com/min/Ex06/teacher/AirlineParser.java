package com.min.Ex06.teacher;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int year;
	private int month;
	private int week;
	private int depTime;
	private int day;
	private int carrierDelay;
	private String UniqueCarrier;
	private String TailNum;
	private int arrDelay;
	private int depDelay;
	private int distance;
	private int WeatherDelay;
	private int actualElapsedTime;
	private int CRSElapsedTime;
	
	final static int SUSPENSIONOFAIRLINE = -1;
	final static int NOTAIRFLIGHT = 0;
	
	private int getDigitFromStr(String str, int defaultDigit) {
		if( "NA".equals( str.toUpperCase() ) )	return defaultDigit;
		return Integer.parseInt(str);
	}
	public AirlineParser(Text txt) {
		String [] airData = txt.toString().split(",");
		year = Integer.parseInt( airData[0] );
		month = Integer.parseInt( airData[1] );
		day = Integer.parseInt(airData[2]);
		week = Integer.parseInt( airData[3] );
		depTime =getDigitFromStr(airData[4], SUSPENSIONOFAIRLINE);
		
		UniqueCarrier = airData[8];
		TailNum = airData[10];
		actualElapsedTime = getDigitFromStr(airData[11], SUSPENSIONOFAIRLINE);
		CRSElapsedTime = getDigitFromStr(airData[12], SUSPENSIONOFAIRLINE);
		arrDelay = getDigitFromStr(airData[14], SUSPENSIONOFAIRLINE);
		depDelay = getDigitFromStr(airData[15], SUSPENSIONOFAIRLINE);
		distance = getDigitFromStr(airData[18], SUSPENSIONOFAIRLINE);
		carrierDelay = getDigitFromStr(airData[24], NOTAIRFLIGHT);
		WeatherDelay = getDigitFromStr(airData[25], NOTAIRFLIGHT);
		
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getWeek() {
		return week;
	}
	public int getDepTime() {
		return depTime;
	}
	public int getDay() {
		return day;
	}
	public int getCarrierDelay() {
		return carrierDelay;
	}
	public String getUniqueCarrier() {
		return UniqueCarrier;
	}
	public String getTailNum() {
		return TailNum;
	}
	public int getArrDelay() {
		return arrDelay;
	}
	public int getDepDelay() {
		return depDelay;
	}
	public int getDistance() {
		return distance;
	}
	public int getWeatherDelay() {
		return WeatherDelay;
	}
	public int getActualElapsedTime() {
		return actualElapsedTime;
	}
	public int getCRSElapsedTime() {
		return CRSElapsedTime;
	}
}
