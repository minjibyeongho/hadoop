package com.min.WordCount;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Map01 extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {	//입력자료 key:value 출력자료 key:value 형식을 정한 것

	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		// 토큰링, 토큰 : 최소한의 어떤 것을 갖는 것
		// 띄어쓰기를 기준으로(default) st를 split하겠다는 의미
		StringTokenizer st = new StringTokenizer(
				value.toString().toLowerCase()
		);
		
		
		while(st.hasMoreTokens()){
			output.collect(new Text(st.nextToken()), new IntWritable(1));
		}
		
	}
	
}
