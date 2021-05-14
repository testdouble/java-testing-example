package spending.triggers.warns;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import spending.values.BigSpend;

public class ComposesSubjectTest {

	ComposesSubject subject = new ComposesSubject();

	@Test
	public void test() {
		Collection<BigSpend> bigSpends = Arrays.asList(new BigSpend(new BigDecimal("5"), null, null),
				new BigSpend(new BigDecimal("8"), null, null));

		String result = subject.compose(bigSpends);

		assertThat(result, is("Unusual spending of $13.00 detected!"));
	}
}