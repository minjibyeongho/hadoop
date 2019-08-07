package com.min.Ex06.teacher;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map01 extends Mapper<LongWritable, Text, Text, Text>{
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		AirlineParser ap = new AirlineParser(value);
		if(ap.getActualElapsedTime()>AirlineParser.SUSPENSIONOFAIRLINE) {
			Text txt = new Text(ap.getUniqueCarrier()+","+ap.getTailNum()+","+ap.getActualElapsedTime());
			context.write(new Text("Actual:"+ap.getYear()), txt);
			
			if(ap.getCRSElapsedTime()>AirlineParser.SUSPENSIONOFAIRLINE) {
				txt = new Text(ap.getUniqueCarrier()+","+ap.getTailNum()+","+ap.getCRSElapsedTime());
				context.write(new Text("CRS:"+ap.getYear()), txt);
			}
		}
	}
}