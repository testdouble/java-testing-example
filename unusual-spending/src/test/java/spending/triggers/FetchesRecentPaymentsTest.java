package spending.triggers;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static spending.SpendingTestHelper.*;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import spending.triggers.fetches.FetchesPaymentsWrapper;
import spending.triggers.fetches.FindsMonths;
import spending.values.Month;
import spending.values.Payment;
import spending.values.RecentPayments;

@RunWith(MockitoJUnitRunner.class)
public class FetchesRecentPaymentsTest {

	@InjectMocks
	FetchesRecentPayments subject;

	@Mock
	FindsMonths findsMonths;

	@Mock
	FetchesPaymentsWrapper fetchesPaymentsWrapper;

	@Test
	public void test() {
		long userId = 42;
		Month thisMonth = new Month(1999, 8);
		Month lastMonth = new Month(1999, 7);
		when(findsMonths.thisMonth()).thenReturn(thisMonth);
		when(findsMonths.lastMonth()).thenReturn(lastMonth);
		Set<Payment> thisMonthPayments = createSet(payment());
		when(fetchesPaymentsWrapper.fetch(userId, thisMonth)).thenReturn(thisMonthPayments);
		Set<Payment> lastMonthPayments = createSet(payment());
		when(fetchesPaymentsWrapper.fetch(userId, lastMonth)).thenReturn(lastMonthPayments);

		RecentPayments result = subject.fetch(userId);

		assertThat(result.currentPayments, is(thisMonthPayments));
		assertThat(result.previousPayments, is(lastMonthPayments));
	}
}