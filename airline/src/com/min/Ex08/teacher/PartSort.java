package com.min.Ex08.teacher;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

public class PartSort extends AirlineParser implements WritableComparable<PartSort>{
	public PartSort() {	}		//default 생성자
	public PartSort(Text value) {
		super(value);
	}
	
	@Override
	public void readFields(DataInput in) throws IOException {
		super.setYear(WritableUtils.readString(in));	//문자열 처리
		super.setMonth(in.readInt());					//숫자처리
	}

	@Override
	public void write(DataOutput out) throws IOException {
		WritableUtils.writeString(out, super.getYear());	//문자열처리
		out.writeInt(super.getMonth());						//숫자처리
	}

	@Override
	public int compareTo(PartSort data) {
		int result = super.getYear().compareTo(data.getYear());
		if(0==result)
			return super.getMonth() - data.getMonth();
		return result;
	}
	
}
