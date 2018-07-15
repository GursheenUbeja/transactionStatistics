package com.TxnStat.services;

import com.TxnStat.domain.Statistics;
import com.TxnStat.domain.Transaction;

public interface StatisticsService {
	
	public Statistics getStats();

	public void calculateStats(Transaction txn);

	
	
}
