package spending.values;

import java.util.Set;

public class RecentPayments {

	public final Set<Payment> currentPayments;
	public final Set<Payment> previousPayments;

	public RecentPayments(Set<Payment> currentPayments, Set<Payment> previousPayments) {
		this.currentPayments = currentPayments;
		this.previousPayments = previousPayments;
	}

}
