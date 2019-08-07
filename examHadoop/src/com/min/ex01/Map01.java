package com.min.ex01;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map01 extends Mapper<LongWritable, Text, Text, IntWritable>  {
	
	//multiple output 실습
	
	/*@Override
	public void map(Text key, Text value, Context output){
		override를 쓰는 이유 : 재정의 시 오타를 방지하기 위해서라도 사용, 
		  override없이 오타가 발생하면 내부 메소드를 새로 만든 것과 같음(위의 Mapper의 메소드 재정의가 아니여서 오류발생위험)
	}*/
	
	@Override		
	public void map(LongWritable key, Text value, Context output) throws IOException, InterruptedException{
		AirlineParser ap = new AirlineParser(value);
		
		if(ap.getCarrierDelay_min()>0){
			output.write(new Text(ap.getUniqueCarrier_min()+"_"+ap.getTailNum_min()),new IntWritable(ap.getCarrierDelay_min()));
		}else{
			output.write(new Text(ap.getUniqueCarrier_min()+"_"+ap.getTailNum_min()), new IntWritable(AirlineParser.NONDELAY));
		}
		
		//실제 넘어가는 데이터
		//dep:uc, arr:uc
	}
	
	//ctrl + shift + o : 자동 import(작성되어 있는 import만 해줌)
}
