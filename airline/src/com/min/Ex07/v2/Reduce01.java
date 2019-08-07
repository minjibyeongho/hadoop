package com.min.Ex07.v2;

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
		int cnt=0;
		
		for(IntWritable v : values)
			cnt += v.get();
		
		multi.write(namedOutput, key, new IntWritable(cnt));
		
		/*multi.write 파라미터 설명
	  	  namedOutput : 출력되는 이름 
		  key : 기존 Key
		  value : 기존 value*/
		 
	}
	
	public void reduce(Text key, Iterable<IntWritable> values, Context output) 
			throws IOException, InterruptedException{
		String[] cmd = key.toString().split(":");
		
		if("yearmonth".equalsIgnoreCase(cmd[0]))	
			multiCount(cmd[0], cmd[1], values);
	}
	
	@Override	//setup과 달리정리해주는 코드
	protected void cleanup(Context ctx) throws IOException, InterruptedException{
		multi.close();
	}
	
	
}
