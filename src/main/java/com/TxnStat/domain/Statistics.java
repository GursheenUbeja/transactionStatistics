package com.TxnStat.domain;

public class Statistics {

	private long timestamp;
	private double sum;
	private double max;
	private double min;
	private long count;
	private double avg;

	public long getTimestamp() {
		return timestamp;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	
	
}
