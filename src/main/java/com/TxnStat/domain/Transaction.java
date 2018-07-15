package com.TxnStat.domain;

public class Transaction {
	
	public Transaction(){
		
	}

	private Double amount;
	private Long timeStamp;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Transaction(Double amount, Long timestamp) {
		this.amount = amount;
		this.timeStamp = timestamp;
	}

}
