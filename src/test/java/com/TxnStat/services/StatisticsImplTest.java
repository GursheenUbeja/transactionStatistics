package com.TxnStat.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.TxnStat.domain.Statistics;
import com.TxnStat.domain.Transaction;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsImplTest {

	@Autowired
	StatisticsService statService;

	@Test
	public void testGetStats() {
		statService.calculateStats(new Transaction(5.5, System.currentTimeMillis() - 10000));
		statService.calculateStats(new Transaction(15.5, System.currentTimeMillis() - 9000));

		Statistics stats = statService.getStats();

		assertEquals(stats.getCount(), 2);
		assertEquals(stats.getAvg(), 50);
		assertEquals(stats.getSum(), 100);
		assertEquals(stats.getMax(), 150);
		assertEquals(stats.getMin(), 11);

	}

}
