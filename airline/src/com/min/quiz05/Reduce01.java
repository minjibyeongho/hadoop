package com.min.quiz05;

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

	@Override
	public void reduce(Text key, Iterator<IntWritable> values, 
			OutputCollector<Text, IntWritable> output, Reporter arg3)
			throws IOException {
		
		int cnt=0;
		
		while(values.hasNext()){
			cnt += values.next().get();
		}
		
		String week;
		int week1;
		
		week1 = Integer.parseInt(key.toString());
		
		if(week1 == 1){
			week = "월 요 일";
		}else if(week1 == 2){
			week = "화 요 일";
		}else if(week1 == 3){
			week = "수 요 일";
		}else if(week1 == 4){
			week = "목 요 일";
		}else if(week1 == 5){
			week = "금 요 일";
		}else if(week1 == 6){
			week = "토 요 일";
		}else{
			week = "일 요 일";
		}
		
		output.collect(new Text(week), new IntWritable(cnt));
	}
}
