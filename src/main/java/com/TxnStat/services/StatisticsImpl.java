package com.TxnStat.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TxnStat.domain.Statistics;
import com.TxnStat.domain.Transaction;
import com.TxnStat.utils.Constants;

@RestController
public class StatisticsImpl implements StatisticsService {

	private static final Map<Long, Statistics> statsMap = new ConcurrentHashMap<>();

	@RequestMapping("/statistics")
	@Override
	public Statistics getStats() {

		Statistics statToReturn = statsMap.values().stream().filter(
				stat -> (System.currentTimeMillis() - stat.getTimestamp()) / Constants.THOUSAND < Constants.SIXTY_SEC)
				.reduce(new Statistics(), (stat1, stat2) -> {
					stat1.setSum(stat1.getSum() + stat2.getSum());
					stat1.setCount(stat1.getCount() + stat2.getCount());
					stat1.setMax(Double.compare(stat1.getMax(), stat2.getMax()) > Constants.ZERO ? stat1.getMax()
							: stat2.getMax());
					stat1.setMin(Double.compare(stat1.getMin(), stat2.getMin()) < Constants.ZERO ? stat2.getMin()
							: stat1.getMin());
					stat1.setAvg(stat1.getSum() / stat1.getCount());
					return stat1;
				});

		return statToReturn;
	}

	@Override
	public void calculateStats(Transaction txn) {
		if ((System.currentTimeMillis() - txn.getTimeStamp()) / Constants.THOUSAND < Constants.SIXTY_SEC) {
			long timeStmp = txn.getTimeStamp();

			statsMap.compute(timeStmp, (key, value) -> {
				if (value == null) {
					
					value = new Statistics();
					value.setTimestamp(txn.getTimeStamp());
					value.setSum(txn.getAmount());
					value.setMax(txn.getAmount());
					value.setMin(txn.getAmount());
					value.setCount(1l);
					return value;
				}
				value.setCount(value.getCount() + 1);
				value.setSum(value.getSum() + txn.getAmount());
				if (Double.compare(txn.getAmount(), value.getMax()) > Constants.ZERO)
					value.setMax(txn.getAmount());
				if (Double.compare(txn.getAmount(), value.getMin()) < Constants.ZERO)
					value.setMin(txn.getAmount());

				return value;
			});
		}

	}

}
