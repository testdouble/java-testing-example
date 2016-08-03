package spending;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import spending.values.Payment;

public class SpendingTestHelper {

	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(Collection<T> coll) {
		return (T[]) coll.toArray();
	}

	public static Payment payment() {
		return new Payment(null, null, null);
	}

	public static <T> Set<T> createSet(T... items) {
		Set<T> set = new HashSet<T>();
		set.addAll(Arrays.asList(items));
		return set;
	}

	public static <K, V> Map<K, V> createMap(K key, V value) {
		Map<K, V> map = new HashMap<K, V>();
		map.put(key, value);
		return map;
	}

}
