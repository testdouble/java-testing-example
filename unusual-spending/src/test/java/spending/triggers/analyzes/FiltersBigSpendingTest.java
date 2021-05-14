package spending.triggers.analyzes;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static spending.SpendingTestHelper.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

import org.junit.Test;

import spending.values.BigSpend;
import spending.values.Category;

public class FiltersBigSpendingTest {

	FiltersBigSpending subject = new FiltersBigSpending();

	@Test
	public void hasBigSpending() {
		Map<Category, BigDecimal> currentTotals = createMap(Category.GOLF, new BigDecimal("16"));
		Map<Category, BigDecimal> previousTotals = createMap(Category.GOLF, new BigDecimal("10"));

		Collection<BigSpend> result = subject.filter(currentTotals, previousTotals);

		assertThat(result.size(), is(1));
		for (BigSpend bigSpend : result) {
			assertThat(bigSpend.usualSpending, is(new BigDecimal("10")));
			assertThat(bigSpend.actualSpending, is(new BigDecimal("16")));
			assertThat(bigSpend.category, is(Category.GOLF));
		}
	}

	@Test
	public void noBigSpending() {
		Map<Category, BigDecimal> currentTotals = createMap(Category.GOLF, new BigDecimal("15"));
		Map<Category, BigDecimal> previousTotals = createMap(Category.GOLF, new BigDecimal("10"));

		Collection<BigSpend> result = subject.filter(currentTotals, previousTotals);

		assertThat(result.size(), is(0));
	}

	@Test
	public void onlyNewSpending() {
		Map<Category, BigDecimal> currentTotals = createMap(Category.GOLF, new BigDecimal("33"));
		Map<Category, BigDecimal> previousTotals = createMap(Category.TV, new BigDecimal("100"));

		Collection<BigSpend> result = subject.filter(currentTotals, previousTotals);

		assertThat(result.size(), is(1));
		for (BigSpend bigSpend : result) {
			assertThat(bigSpend.usualSpending, is(new BigDecimal("0")));
			assertThat(bigSpend.actualSpending, is(new BigDecimal("33")));
			assertThat(bigSpend.category, is(Category.GOLF));
		}
	}
}