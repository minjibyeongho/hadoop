package com.min.Ex01;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class QuizMain extends Configured
implements Tool{
	public static void main(String[] args) throws Exception {
		System.exit( ToolRunner.run(new QuizMain(), args));
	}

	@Override
	public int run(String[] arg0) throws Exception {
		Job conf = Job.getInstance(getConf(), "ArrDep");
		//mapreduce에 있는 Job을 활용, name을 위에서 정하기 때문에 하위의 것이 필요없음
		
		//conf.setJobName("delay test");
		
		//출력 형식 지정
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		
		/*//Map01, Reduce01과는 달리 Map과 Reduce 출력 형식이 달라져서 Map 출력형식 지정이필요하다
		
		//Map 출력 형식 지정
		conf.setMapOutputKeyClass(IntWritable.class);
		conf.setMapOutputValueClass(IntWritable.class);*/
		
		//Map Reduce
		conf.setMapperClass(Map01.class);
		conf.setReducerClass(Reduce01.class);
		
		//입출력 형식 지정
		conf.setInputFormatClass(TextInputFormat.class);
		conf.setOutputFormatClass(TextOutputFormat.class);
		
		//입출력 경로 지정
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(conf, new Path(arg0[1]));
		
		//실행
		//JobClient.runJob(conf);
		conf.waitForCompletion(true);
		return 0;
	}
	
	
}
