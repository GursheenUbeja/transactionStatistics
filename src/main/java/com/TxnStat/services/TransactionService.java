package com.TxnStat.services;

import com.TxnStat.domain.Transaction;

public interface TransactionService {

	public String insertTransaction(Transaction txn) throws Exception;

}
