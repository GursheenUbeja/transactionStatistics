package com.TxnStat.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.TxnStat.domain.Transaction;
import com.TxnStat.utils.TxnStatException;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionImplTest {

	@Autowired
	private TransactionService transactionService;

	@Test(expected=TxnStatException.class)
	public void testInsertTransaction() throws Exception {
		transactionService.insertTransaction(new Transaction(12.5, null));
		transactionService.insertTransaction(new Transaction(null,1531625933473l ));
		transactionService.insertTransaction(new Transaction(45d,1531631229248l ));
	}

	@Test()
	public void successTransaction() throws Exception {
		
		transactionService.insertTransaction(new Transaction(45d,System.currentTimeMillis() ));
	}

	
}
