package com.min.Ex04;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce01 extends Reducer<Text, IntWritable, Text, IntWritable> {
	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context output) 
			throws IOException, InterruptedException{
		int cnt=0;
		
		for(IntWritable v :values){
			cnt += v.get();
		}
		
		output.write(key, new IntWritable(cnt));
		
	}
	
}
