package com.min.Ex05;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class Reduce01 extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	private MultipleOutputs<Text, IntWritable> multi;
	
	@Override
	protected void setup(Context ctx){
		multi = new MultipleOutputs<Text, IntWritable>(ctx);
	}
	
	private void multiCount(String namedOutput, String key, Iterable<IntWritable> values) throws IOException, InterruptedException{
		int total=0;
		
		// value값을 합치는 곳
		for(IntWritable v : values)
			total += v.get();
		
		multi.write(namedOutput, key, new IntWritable(total));
		
		
		/*	multi.write 파라미터 설명
		 * 	namedOutput : 출력되는 이름 
		 *  key : 기존 Key
		 *  value : 기존 value
		 * */
	}
	
	public void reduce(Text key, Iterable<IntWritable> values, Context output) 
			throws IOException, InterruptedException{
		
		/*
		 * 하위 내용 함수화 작업(multiCount)
		 * int cnt=0;
		
		for(IntWritable v : values)
			cnt += v.get();*/
		String[] cmd =key.toString().split(":");
/*		
		if("dep".equalsIgnoreCase(cmd[0]))	multiCount("dep", cmd[1], values);
		if("arr".equalsIgnoreCase(cmd[0]))	multiCount("arr", cmd[1], values);
*/
		
		//위에 것과 같은 코드
		if("dep".equalsIgnoreCase(cmd[0]) || "arr".equalsIgnoreCase(cmd[0]))	
			multiCount(cmd[0], cmd[1], values);
	}
	
	@Override	//setup과 달리정리해주는 코드
	protected void cleanup(Context ctx) throws IOException, InterruptedException{
		multi.close();
	}
	
	
}
