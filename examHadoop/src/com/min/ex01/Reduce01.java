package com.min.ex01;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce01 extends Reducer<Text, IntWritable, Text, DoubleWritable> {
	
	public void reduce(Text key, Iterable<IntWritable> values, Context output) 
			throws IOException, InterruptedException{
		// String[] cmd = key.toString().split(":");
		//actual:Uni_Tailnum / flightnum / values(운항 시간 값 : intwritable) 
		
		int delay = 0;
		int allCnt = 0;
		int delayCnt = 0;
		double delayRate = 0;
		
		while(values.iterator().hasNext()){
			delay = values.iterator().next().get();
			allCnt++;
			if(delay>0){
				delayCnt++;
			}
		}
		
		delayRate = ((double)delayCnt /allCnt);	//지연율(낙후도)
		
		output.write(key, new DoubleWritable(delayRate));
	}
		
}
