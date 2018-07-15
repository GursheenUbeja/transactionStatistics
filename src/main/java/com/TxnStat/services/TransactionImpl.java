package com.TxnStat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TxnStat.domain.Transaction;
import com.TxnStat.utils.Constants;
import com.TxnStat.utils.TxnStatException;

@RestController
@RequestMapping("/transactions")
public class TransactionImpl implements TransactionService {

	@Autowired
	StatisticsService statService;

	@PostMapping
	@Override
	public String insertTransaction(@RequestBody Transaction txn) throws Exception {

		String ret = "Success";

		if (txn == null || txn.getAmount() == null || txn.getTimeStamp() == null)
			return new TxnStatException(Constants.ERR_204, "Please enter valid transaction values").getErrorMessage();

		if ((double)(System.currentTimeMillis() - txn.getTimeStamp()) / 1000.0 >= 60.0)
			return new TxnStatException(Constants.ERR_204, "Transaction is older than 60 secs").getErrorMessage();

		statService.calculateStats(txn);
		return ret + "Code : +" + Constants.SUCCESS_201;

	}

}
