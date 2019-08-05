package com.min.quiz05.teacher;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Reduce01 extends MapReduceBase
implements Reducer<Text, IntWritable, Text, IntWritable>{

	private IntWritable getTotalCnt(Iterator<IntWritable> values){
		int cnt=0;
		
		while(values.hasNext()){
			cnt += values.next().get();
		}
		
		return new IntWritable(cnt);
		
	}
	
	private String getWeek(int idx) {
		String week = "";
		if(idx==1) week="월요일";
		else if(idx==2) week="화요일";
		else if(idx==3) week="수요일";
		else if(idx==4) week="목요일";
		else if(idx==5) week="금요일";
		else if(idx==6) week="토요일";
		else if(idx==7) week="일요일";
		
		return week;
	}
	
	@Override
	public void reduce(Text key, Iterator<IntWritable> values, 
			OutputCollector<Text, IntWritable> output, Reporter arg3)
			throws IOException {
		
		output.collect(
				new Text(getWeek(Integer.parseInt(key.toString()))), 
				getTotalCnt(values)
				);
	}
}
