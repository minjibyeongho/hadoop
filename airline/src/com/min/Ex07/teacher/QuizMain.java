package com.min.Ex07.teacher;

import org.apache.hadoop.conf.Configuration;
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

public class QuizMain extends Configured implements Tool{
	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new Configuration(), new QuizMain(), args);
		System.exit(exitCode);
	}

	@Override
	public int run(String[] arg0) throws Exception {
		Job job = Job.getInstance(getConf(), "NonSort");
		
		FileInputFormat.addInputPath(job, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
		
		job.setJarByClass(QuizMain.class);
		// 키로 정렬
		//job.setSortComparatorClass(PartSortComparator.class);
		// 그룹으로 묶어서 정렬
		job.setGroupingComparatorClass(PartSortComparator.class);
		
		job.setMapperClass(Map01.class);
		job.setReducerClass(Reduce01.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		job.setMapOutputKeyClass(PartSort.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.waitForCompletion(true);
		
		return 0;

	}
	
	
}
