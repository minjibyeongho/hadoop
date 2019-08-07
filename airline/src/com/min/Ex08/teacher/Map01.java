package com.min.Ex08.teacher;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map01 extends Mapper<LongWritable, Text, PartSort, IntWritable> {
	@Override
	public void map(LongWritable key, Text value, Context ctx) throws IOException, InterruptedException {
		//AirlineParser ap = new AirlineParser(value);
		PartSort data = new PartSort(value);
		
		if(data.getCancelled() == data.NONCANCELLED)
			ctx.write(
				data, 
				new IntWritable(1)
			);
	}
}
