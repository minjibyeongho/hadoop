package com.min.airline;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Map01 extends MapReduceBase
implements Mapper<LongWritable, Text , Text, Text>{

	@Override
	public void map(LongWritable key, Text value, 
			OutputCollector<Text, Text> output, Reporter arg3) throws IOException {	//Reporter는 오늘 안씀
		output.collect(new Text(key.toString()), value);
	}
}
