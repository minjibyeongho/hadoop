package com.min.WordCount;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Reduce01 extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {

	@Override	//iterator는 연결리스트 형식으로 hasNext()를 통해서 값이 있는지 없는지를 확인
	public void reduce(Text key, Iterator<IntWritable> values, 
			OutputCollector<Text, IntWritable> output, 
			Reporter reporter)
			throws IOException {
		int cnt = 0;
		
		while(values.hasNext())
			cnt += values.next().get();
		
		output.collect(key, new IntWritable(cnt));
	}

	
}
