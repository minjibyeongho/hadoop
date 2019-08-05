package com.min.quiz06;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class QuizMain02 extends Configured
implements Tool{
	public static void main(String[] args) throws Exception {
		System.exit( ToolRunner.run(new QuizMain02(), args));
	}

	@Override
	public int run(String[] arg0) throws Exception {
		JobConf conf = new JobConf();
		
		conf.setJobName("quiz test");
		
		//출력 형식 지정
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		
		/*//Map01, Reduce01과는 달리 Map과 Reduce 출력 형식이 달라져서 Map 출력형식 지정이필요하다
		
		//Map 출력 형식 지정
		conf.setMapOutputKeyClass(IntWritable.class);
		conf.setMapOutputValueClass(IntWritable.class);*/
		
		//Map Reduce
		conf.setMapperClass(Map02.class);
		conf.setReducerClass(Reduce02.class);
		
		//입출력 형식 지정
		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);
		
		//입출력 경로 지정
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(conf, new Path(arg0[1]));
		
		//실행
		JobClient.runJob(conf);
		return 0;
	}
	
	
}
