package spending.triggers.analyzes;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static spending.SpendingTestHelper.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import spending.values.Category;
import spending.values.Payment;

public class SumsTotalsTest {

	SumsTotals subject = new SumsTotals();

	@Test
	public void test() {
		Map<Category, Set<Payment>> payments = createMap(Category.GOLF,
				createSet(new Payment(Category.GOLF, new BigDecimal("1"), ""),
						new Payment(Category.GOLF, new BigDecimal("5"), ""),
						new Payment(Category.GOLF, new BigDecimal("7"), "")));

		Map<Category, BigDecimal> result = subject.sum(payments);

		assertThat(result, is(createMap(Category.GOLF, new BigDecimal("13"))));
	}
}