package com.min.quiz09.teacher;

import java.io.IOException;
import java.util.Iterator;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Reduce02 extends MapReduceBase
implements Reducer<Text, IntWritable, Text, Text>{

	private Text getTotalCnt(Iterator<IntWritable> values){
		int delayCnt=0, totalCnt=0, sum=0;
		
		
		
		while(values.hasNext()){
			totalCnt++;
			int delayTime = values.next().get();
			if(delayTime > AirlineParser.NONDELAY){
				delayCnt++;
				//sum += values.next().get();
				// next하고 next하면 다른 값이 되어 버림으로 위에 변수를 주어줌
				sum += delayTime;
			}
		}
		//if(delayCnt==0 || totalCnt==0)
		if(delayCnt * totalCnt==0)
			return new Text("sum : 0, avg : 0, delayrate : 0");
		
		return new Text(
				String.format("sum : %d, avg : %.2f, delayrate : %.2f", 
						sum, (float)sum/(float)delayCnt, 
						(float)delayCnt/(float)totalCnt*100.0)
				);
	}
	
	
	@Override
	public void reduce(Text key, Iterator<IntWritable> values, 
			OutputCollector<Text, Text> output, Reporter arg3)
			throws IOException {
			  
			output.collect(key, new Text(getTotalCnt(values)));

	}
}
