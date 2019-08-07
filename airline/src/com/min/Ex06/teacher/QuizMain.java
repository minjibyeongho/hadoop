package com.min.Ex06.teacher;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class QuizMain extends Configured implements Tool{
	
	@Override
	public int run(String[] arg0) throws Exception {
		String[] MultipleId = {"Actual", "CRS"};
		Job job = Job.getInstance(getConf(), "ArrDep");
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.setMapperClass(Map01.class);
		job.setReducerClass(Reduce01.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		FileInputFormat.setInputPaths(job, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
		
		MultipleOutputs.addNamedOutput(job, MultipleId[0], TextOutputFormat.class, Text.class, IntWritable.class);
		MultipleOutputs.addNamedOutput(job, MultipleId[1], TextOutputFormat.class, Text.class, IntWritable.class);
		job.waitForCompletion(true);
		
		return 0;
	}
	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new QuizMain(), args);
		System.exit(exitCode);
	}
}
