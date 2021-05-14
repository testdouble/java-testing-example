package spending.triggers.fetches;

import java.util.Set;

import spending.FetchesUserPaymentsByMonth;
import spending.values.Month;
import spending.values.Payment;

public class FetchesPaymentsWrapper {

	FetchesUserPaymentsByMonth<Payment> fetchesUserPaymentsByMonth = FetchesUserPaymentsByMonth.getInstance();

	public Set<Payment> fetch(long userId, Month month) {
		return fetchesUserPaymentsByMonth.fetch(userId, month.year, month.month);
	}

}
