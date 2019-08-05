package com.min.quiz06.teacher;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Map02 extends MapReduceBase
implements Mapper<LongWritable, Text, Text, IntWritable>{

	@Override
	public void map(LongWritable key, Text value, 
			OutputCollector<Text, IntWritable> output, Reporter arg3)
			throws IOException {
		AirlineParser ap = new AirlineParser(value);
		if(ap.getCancelled()==ap.CANCELLED){
			String yearmonth = String.format("%d년 %02d월",
					ap.getYear(), ap.getMonth());
			
			output.collect(
					new Text(yearmonth), 
					new IntWritable(ap.getCancelled()));
		}
		
		
	}
}
