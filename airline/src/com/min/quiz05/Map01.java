package com.min.quiz05;

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
		//AirlineParser ap = new AirlineParser(value);
		//String week = ap.getWeek();
		String[] airData = value.toString().split(",");
		
		output.collect(new Text(airData[3]), new IntWritable(1));
		
	}

	
}
