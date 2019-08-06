package com.min.Ex06;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class Reduce01 extends Reducer<Text, IntWritable, Text, Text> {
	
	private MultipleOutputs<Text, Text> multi;
	
	@Override
	protected void setup(Context ctx){
		multi = new MultipleOutputs<Text, Text>(ctx);
	}
	
	private void multiCount(String namedOutput, String key, Iterable<IntWritable> values) throws IOException, InterruptedException{
		int total=0;
		int tmp=0;
		String[] cmo = key.split("/");
		
		for(IntWritable v : values)
			total += v.get();
		
		if(tmp < total){
			tmp = total;
			multi.write(namedOutput, cmo[0], new Text(cmo[1]));
		}
		
		/*	multi.write 파라미터 설명
		 * 	namedOutput : 출력되는 이름 
		 *  key : 기존 Key
		 *  value : 기존 value
		 * */
	}
	
	public void reduce(Text key, Iterable<IntWritable> values, Context output) 
			throws IOException, InterruptedException{
		String[] cmd =key.toString().split(":");
		//actual:Uni_Tailnum:flightnum / values(운항 시간 값 : intwritable) 
		
		//위에 것과 같은 코드
		if("actual".equalsIgnoreCase(cmd[0]) || "CRS".equalsIgnoreCase(cmd[0]))	
			multiCount(cmd[0], cmd[1], values);
	}
	
	@Override	//setup과 달리정리해주는 코드
	protected void cleanup(Context ctx) throws IOException, InterruptedException{
		multi.close();
	}
	
	
}
