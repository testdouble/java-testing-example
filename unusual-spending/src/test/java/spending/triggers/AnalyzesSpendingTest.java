package spending.triggers;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static spending.SpendingTestHelper.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import spending.triggers.analyzes.FiltersBigSpending;
import spending.triggers.analyzes.GroupsByCategory;
import spending.triggers.analyzes.SumsTotals;
import spending.values.BigSpend;
import spending.values.Category;
import spending.values.Payment;
import spending.values.RecentPayments;

@RunWith(MockitoJUnitRunner.class)
public class AnalyzesSpendingTest {

	@InjectMocks
	AnalyzesSpending subject;

	@Mock
	GroupsByCategory groupsByCategory;

	@Mock
	SumsTotals sumsTotals;

	@Mock
	FiltersBigSpending filtersBigSpending;

	@Test
	public void test() {
		Set<Payment> currentPayments = createSet(payment());
		Set<Payment> previousPayments = createSet(payment());
		RecentPayments payments = new RecentPayments(currentPayments, previousPayments);
		Map<Category, Set<Payment>> currentCategorizedPayments = createMap(Category.TV, createSet(payment()));
		Map<Category, Set<Payment>> previousCategorizedPayments = createMap(Category.GOLF, createSet(payment()));
		when(groupsByCategory.group(currentPayments)).thenReturn(currentCategorizedPayments);
		when(groupsByCategory.group(previousPayments)).thenReturn(previousCategorizedPayments);
		Map<Category, BigDecimal> currentTotals = createMap(Category.TV, new BigDecimal("88"));
		Map<Category, BigDecimal> previousTotals = createMap(Category.GOLF, new BigDecimal("44"));
		when(sumsTotals.sum(currentCategorizedPayments)).thenReturn(currentTotals);
		when(sumsTotals.sum(previousCategorizedPayments)).thenReturn(previousTotals);
		Collection<BigSpend> bigSpending = Arrays.asList(new BigSpend(null, null, null));
		when(filtersBigSpending.filter(currentTotals, previousTotals)).thenReturn(bigSpending);

		Collection<BigSpend> result = subject.analyze(payments);

		assertThat(result, is(bigSpending));
	}
}