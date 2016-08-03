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

public class GroupsByCategoryTest {

	GroupsByCategory subject = new GroupsByCategory();

	@Test
	public void test1() {
		Payment tv = new Payment(Category.TV, new BigDecimal("23"), "Cable bill");

		Map<Category, Set<Payment>> result = subject.group(createSet(tv));

		assertThat(result.get(Category.TV), is(createSet(tv)));
	}

	@Test
	public void test1and1() {
		Payment tv = new Payment(Category.TV, new BigDecimal("23"), "Cable bill");
		Payment golf = new Payment(Category.GOLF, new BigDecimal("232"), "clubs");

		Map<Category, Set<Payment>> result = subject.group(createSet(tv, golf));

		assertThat(result.get(Category.TV), is(createSet(tv)));
		assertThat(result.get(Category.GOLF), is(createSet(golf)));
	}

	@Test
	public void test1and2() {
		Payment tv = new Payment(Category.TV, new BigDecimal("23"), "Cable bill");
		Payment golf = new Payment(Category.GOLF, new BigDecimal("232"), "clubs");
		Payment golf2 = new Payment(Category.GOLF, new BigDecimal("99"), "moar clubs");

		Map<Category, Set<Payment>> result = subject.group(createSet(tv, golf, golf2));

		assertThat(result.get(Category.TV), is(createSet(tv)));
		assertThat(result.get(Category.GOLF), is(createSet(golf, golf2)));
	}
}