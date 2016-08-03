package spending.triggers.warns;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import spending.values.BigSpend;
import spending.values.Category;

public class ComposesBodyTest {

	ComposesBody subject = new ComposesBody();

	@Test
	public void test() {
		Collection<BigSpend> bigSpends = Arrays.asList(new BigSpend(new BigDecimal("148"), null, Category.GROCERIES),
				new BigSpend(new BigDecimal("928"), null, Category.TRAVEL));

		String result = subject.compose(bigSpends);

		String[] lines = result.split("\n");
		assertThat(lines[0], is("Hello card user!"));
		assertThat(lines[2], is("We have detected unusually high spending on your card in these categories:"));
		assertThat(lines[4], is("* You spent $148.00 on groceries"));
		assertThat(lines[5], is("* You spent $928.00 on travel"));
		assertThat(lines[7], is("Love,"));
		assertThat(lines[9], is("The Credit Card Company"));
	}
}