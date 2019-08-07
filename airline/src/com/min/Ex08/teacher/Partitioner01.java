package com.min.Ex08.teacher;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class Partitioner01 extends Partitioner<PartSort, IntWritable> {

	@Override
	public int getPartition(PartSort key, IntWritable value, int numPartitions) {
		
		int hash = key.getYear().hashCode();
		int partition = hash % numPartitions;
		
		return partition;
	}
}
