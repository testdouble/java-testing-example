package spending;

import java.util.Set;

public class FetchesUserPaymentsByMonth<T> {

	public static <T> FetchesUserPaymentsByMonth<T> getInstance() {
		return new FetchesUserPaymentsByMonth<T>();
	}

	private FetchesUserPaymentsByMonth() {
	}

	public Set<T> fetch(long userId, int year, int month) {
		throw new RuntimeException("Data access will be implemented by a different team later");
	}

}
