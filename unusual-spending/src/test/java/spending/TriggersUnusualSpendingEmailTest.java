package spending;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import spending.triggers.AnalyzesSpending;
import spending.triggers.FetchesRecentPayments;
import spending.triggers.WarnsBigSpenders;
import spending.values.BigSpend;
import spending.values.RecentPayments;

@RunWith(MockitoJUnitRunner.class)
public class TriggersUnusualSpendingEmailTest {

	@InjectMocks
	TriggersUnusualSpendingEmail subject;

	@Mock
	FetchesRecentPayments fetchesRecentPayments;

	@Mock
	AnalyzesSpending analyzesSpending;

	@Mock
	WarnsBigSpenders warnsBigSpenders;

	@Test
	public void userIsABigSpender() {
		long userId = 42;
		RecentPayments payments = new RecentPayments(null, null);
		Collection<BigSpend> bigSpends = Arrays.asList(new BigSpend(null, null, null));
		when(fetchesRecentPayments.fetch(userId)).thenReturn(payments);
		when(analyzesSpending.analyze(payments)).thenReturn(bigSpends);

		subject.trigger(userId);

		verify(warnsBigSpenders).warn(userId, bigSpends);
	}

	@Test
	public void userIsNotABigSpender() {
		long userId = 42;
		RecentPayments payments = new RecentPayments(null, null);
		when(fetchesRecentPayments.fetch(userId)).thenReturn(payments);
		when(analyzesSpending.analyze(payments)).thenReturn(new ArrayList<BigSpend>());

		subject.trigger(userId);

		verify(warnsBigSpenders, never()).warn(userId, new ArrayList<BigSpend>());
	}
}