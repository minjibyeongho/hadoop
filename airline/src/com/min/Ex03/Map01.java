package com.min.Ex03;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map01 extends Mapper<LongWritable, Text, Text, IntWritable>  {
	
	/*@Override
	public void map(Text key, Text value, Context output){
		override를 쓰는 이유 : 재정의 시 오타를 방지하기 위해서라도 사용, 
		  override없이 오타가 발생하면 내부 메소드를 새로 만든 것과 같음(위의 Mapper의 메소드 재정의가 아니여서 오류발생위험)
	}*/
	
	@Override		
	public void map(LongWritable key, Text value, Context output) throws IOException, InterruptedException{
		AirlineParser ap = new AirlineParser(value);
		
		
		
		
		if(ap.getWeatherDelay()>0){
			
			output.write(new Text("weather All"),
					new IntWritable(ap.getWeatherDelay()));
			
			switch (ap.getMonth()) {
			case 1:
				output.getCounter(MonthCount.jan).increment(ap.getWeatherDelay());
				break;
			case 2:
				output.getCounter(MonthCount.feb).increment(ap.getWeatherDelay());
				break;
			case 3:
				output.getCounter(MonthCount.mar).increment(ap.getWeatherDelay());
				break;
			case 4:
				output.getCounter(MonthCount.apr).increment(ap.getWeatherDelay());
				break;
			case 5:
				output.getCounter(MonthCount.may).increment(ap.getWeatherDelay());
				break;
			case 6:
				output.getCounter(MonthCount.jun).increment(ap.getWeatherDelay());
				break;
			case 7:
				output.getCounter(MonthCount.jul).increment(ap.getWeatherDelay());
				break;
			case 8:
				output.getCounter(MonthCount.aug).increment(ap.getWeatherDelay());
				break;
			case 9:
				output.getCounter(MonthCount.sep).increment(ap.getWeatherDelay());
				break;
			case 10:
				output.getCounter(MonthCount.oct).increment(ap.getWeatherDelay());
				break;
			case 11:
				output.getCounter(MonthCount.nov).increment(ap.getWeatherDelay());
				break;
			case 12:
				output.getCounter(MonthCount.dec).increment(ap.getWeatherDelay());
				break;
				
			default:
				break;
			}
		}
	}
	
	//ctrl + shift + o : 자동 import(작성되어 있는 import만 해줌)
}
