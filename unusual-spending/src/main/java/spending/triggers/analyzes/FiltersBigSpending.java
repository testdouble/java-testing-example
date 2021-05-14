package spending.triggers.analyzes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import spending.values.BigSpend;
import spending.values.Category;

public class FiltersBigSpending {

	public Collection<BigSpend> filter(Map<Category, BigDecimal> currentTotals,
			Map<Category, BigDecimal> previousTotals) {
		Collection<BigSpend> bigSpends = new ArrayList<BigSpend>();
		for (Map.Entry<Category, BigDecimal> currentEntry : currentTotals.entrySet()) {
			BigDecimal currentTotal = currentEntry.getValue();
			BigDecimal previousTotal = previousTotals.get(currentEntry.getKey());
			if (previousTotal == null) {
				bigSpends.add(new BigSpend(currentTotal, new BigDecimal("0"), currentEntry.getKey()));
			} else if (isGreater(currentTotal, significantlyHigher(previousTotal))) {
				bigSpends.add(new BigSpend(currentTotal, previousTotal, currentEntry.getKey()));
			}
		}
		return bigSpends;
	}

	private boolean isGreater(BigDecimal isThisGreater, BigDecimal thanThis) {
		return isThisGreater.compareTo(thanThis) == 1;
	}

	private BigDecimal significantlyHigher(BigDecimal amount) {
		return amount.multiply(new BigDecimal("1.5"));
	}

}
