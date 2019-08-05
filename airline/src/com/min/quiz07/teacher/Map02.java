package com.min.quiz07.teacher;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Map02 extends MapReduceBase
implements Mapper<LongWritable, Text, IntWritable, IntWritable>{

	@Override
	public void map(LongWritable key, Text value, 
			OutputCollector<IntWritable, IntWritable> output, Reporter arg3)
			throws IOException {
		AirlineParser ap = new AirlineParser(value);
		
		
		String message = "";
		if(ap.getCancelled() == 0){
			// 1-10	(x-1) / 10 = 0
			// 11-20 (x-1) / 10 = 1
			// 21-31 (x-1) / 10 = 2, 3
			int day = (ap.getDate() - 1)/10;
			if(day==3) day=2;
		}
			output.collect(
					new IntWritable(day), 
					new IntWritable(1));
		}
	}
}
