package com.min.quiz;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Map01 extends MapReduceBase
implements Mapper<LongWritable, Text, Text, LongWritable>{

	@Override
	public void map(LongWritable key, Text value, 
			OutputCollector<Text, LongWritable> output, Reporter arg3)
			throws IOException {
		String[] quiz = value.toString().split(",");
		
		output.collect(new Text(quiz[3]), key);
		
	}

	
}
