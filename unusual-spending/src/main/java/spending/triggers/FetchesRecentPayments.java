package spending.triggers;

import java.util.Set;

import spending.triggers.fetches.FetchesPaymentsWrapper;
import spending.triggers.fetches.FindsMonths;
import spending.values.Payment;
import spending.values.RecentPayments;

public class FetchesRecentPayments {

	FindsMonths findsMonths = new FindsMonths();
	FetchesPaymentsWrapper fetchesPaymentsWrapper = new FetchesPaymentsWrapper();

	public RecentPayments fetch(long userId) {
		Set<Payment> currentPayments = fetchesPaymentsWrapper.fetch(userId, findsMonths.thisMonth());
		Set<Payment> previousPayments = fetchesPaymentsWrapper.fetch(userId, findsMonths.lastMonth());
		return new RecentPayments(currentPayments, previousPayments);
	}

}
