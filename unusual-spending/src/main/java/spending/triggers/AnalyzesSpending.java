package spending.triggers;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

import spending.triggers.analyzes.FiltersBigSpending;
import spending.triggers.analyzes.GroupsByCategory;
import spending.triggers.analyzes.SumsTotals;
import spending.values.BigSpend;
import spending.values.Category;
import spending.values.RecentPayments;

public class AnalyzesSpending {

	GroupsByCategory groupsByCategory = new GroupsByCategory();
	SumsTotals sumsTotals = new SumsTotals();
	FiltersBigSpending filtersBigSpending = new FiltersBigSpending();

	public Collection<BigSpend> analyze(RecentPayments payments) {
		Map<Category, BigDecimal> currentTotals = sumsTotals.sum(groupsByCategory.group(payments.currentPayments));
		Map<Category, BigDecimal> previousTotals = sumsTotals.sum(groupsByCategory.group(payments.previousPayments));
		return filtersBigSpending.filter(currentTotals, previousTotals);
	}

}
