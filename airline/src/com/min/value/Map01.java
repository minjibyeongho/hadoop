package com.min.value;

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
		//2008,1,3,4,2003,1955 ...
		// 위와 같은 자료를 split해서 airdata String 배열에 넣어줌
		String[] airData = value.toString().split(",");
		
		output.collect(new Text(airData[10]), key);
	}

}
