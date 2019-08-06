package com.min.Ex01;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map01 extends Mapper<LongWritable, Text, Text, IntWritable> {
	private String opt;	//-D opt = dep(출발 지연시간), -D opt = arr
	//옵션에 따라 값을 따로받을 수 있도록 설계
	
	// 클래스 생성시, 즉 Map01 생성시 초기화, 생성자 이후 동작됨.
	@Override
	protected void setup(Context ctx){
		opt = ctx.getConfiguration().get("opt");
	}
	
	@Override	//mapper자체를 받아서 처리하는 Context가 생김
	public void map(LongWritable key, Text value, Context output) throws IOException, InterruptedException{
		AirlineParser ap = new AirlineParser(value);
		
		int delay=0;
		if("dep".equalsIgnoreCase(opt)) delay = ap.getDepDelay();
		else if("arr".equalsIgnoreCase(opt)) delay = ap.getArrDelay();
		
		if(delay>0){
			output.write(
					new Text(ap.getUniqueCarrier()), 
					new IntWritable(1)
					);
			
		}
		
	}
	
	
	//ctrl + shift + o : 자동 import(작성되어 있는 import만 해줌)
	
	
}
