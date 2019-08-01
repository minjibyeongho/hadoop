package com.min.quiz04;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Map01 extends MapReduceBase
implements Mapper<LongWritable, Text, Text, IntWritable>{

	@Override
	public void map(LongWritable key, Text value, 
			OutputCollector<Text, IntWritable> output, Reporter arg3)
			throws IOException {
		//2008, 1, 3, 4, 2003
		AirlineParser ap = new AirlineParser(value);
		
		String yearMonth = ap.getYear() + "년" + ap.getMonth()+"월";
		/*String[] quiz = value.toString().split(",");
		String quiz1 = quiz[0]+"년 "+quiz[1]+"월";*/
		
		yearMonth = String.format("%d년 %02d월", ap.getYear(), Integer.parseInt(ap.getMonth()));	
		
		//format String : %2d는 2의 공간을 잡아줌
		// String.format("%05d",10) - 00010 빈공간에 0을 채워줌
		
		output.collect(new Text(yearMonth), new IntWritable(1));
		
	}

	
}
