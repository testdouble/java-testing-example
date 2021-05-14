package spending.triggers.analyzes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import spending.values.Category;
import spending.values.Payment;

public class SumsTotals {

	public Map<Category, BigDecimal> sum(Map<Category, Set<Payment>> payments) {
		Map<Category, BigDecimal> totals = new HashMap<Category, BigDecimal>();
		for (Map.Entry<Category, Set<Payment>> entry : payments.entrySet()) {
			totals.put(entry.getKey(), sumOf(entry.getValue()));
		}
		return totals;
	}

	private BigDecimal sumOf(Set<Payment> payments) {
		BigDecimal sum = new BigDecimal("0");
		for (Payment payment : payments) {
			sum = sum.add(payment.price);
		}
		return sum;
	}

}
