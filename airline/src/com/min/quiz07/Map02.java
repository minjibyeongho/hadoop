package com.min.quiz07;

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
		
		
		String message = "";
		if(ap.getCancelled() == 0){
			if(ap.getDate()>=1 && ap.getDate()<=10){
				message = "01 ~ 10";
			}else if(ap.getDate()>=11 && ap.getDate()<=20){
				message = "11 ~ 20";
			}else if(ap.getDate()>=21 && ap.getDate()<=31){
				message = "21 ~ 31";
			}
			
			output.collect(
					new Text(message), 
					new IntWritable(1));
		}
	}
}
