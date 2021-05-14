package spending.triggers.analyzes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import spending.values.Category;
import spending.values.Payment;

public class GroupsByCategory {

	public Map<Category, Set<Payment>> group(Set<Payment> payments) {
		HashMap<Category, Set<Payment>> groupedPayments = new HashMap<Category, Set<Payment>>();
		for (Payment payment : payments) {
			if (!groupedPayments.containsKey(payment.category)) {
				groupedPayments.put(payment.category, new HashSet<Payment>());
			}
			groupedPayments.get(payment.category).add(payment);
		}
		return groupedPayments;
	}

}
