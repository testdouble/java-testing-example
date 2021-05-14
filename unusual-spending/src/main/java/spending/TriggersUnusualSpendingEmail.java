package spending;

import java.util.Collection;

import spending.triggers.AnalyzesSpending;
import spending.triggers.FetchesRecentPayments;
import spending.triggers.WarnsBigSpenders;
import spending.values.BigSpend;
import spending.values.RecentPayments;

public class TriggersUnusualSpendingEmail {

	FetchesRecentPayments fetchesRecentPayments = new FetchesRecentPayments();
	AnalyzesSpending analyzesSpending = new AnalyzesSpending();
	WarnsBigSpenders warnsBigSpenders = new WarnsBigSpenders();

	public void trigger(long userId) {
		RecentPayments payments = fetchesRecentPayments.fetch(userId);
		Collection<BigSpend> bigSpends = analyzesSpending.analyze(payments);
		if (!bigSpends.isEmpty()) {
			warnsBigSpenders.warn(userId, bigSpends);
		}
	}

}
