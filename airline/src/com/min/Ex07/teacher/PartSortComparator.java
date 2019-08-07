package com.min.Ex07.teacher;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class PartSortComparator extends WritableComparator {
	
	public PartSortComparator() {
		super(PartSort.class, true);
	}
	
	//경고 무시에 사용되며 rawtypes의 경고를 무시함. 형변환에 대한 경고 무시
	@SuppressWarnings("rawtypes")
	@Override
	public int compare(WritableComparable obj1, WritableComparable obj2) {
		PartSort data1 = (PartSort)obj1;
		PartSort data2 = (PartSort)obj2;
		
		return data1.compareTo(data2);
	}
}
