package spending.triggers.fetches;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import spending.values.Month;

public class FindsMonthsTest {

	FindsMonths subject = new FindsMonths();

	@Test
	public void thisMonthIsThisMonth() {
		Calendar now = GregorianCalendar.getInstance();

		Month result = subject.thisMonth();

		assertThat(result.month, is(now.get(Calendar.MONTH)));
		assertThat(result.year, is(now.get(Calendar.YEAR)));
	}

	@Test
	public void lastMonthIsLastMonth() {
		Calendar lastMonth = GregorianCalendar.getInstance();
		lastMonth.add(Calendar.MONTH, -1);

		Month result = subject.lastMonth();

		assertThat(result.month, is(lastMonth.get(Calendar.MONTH)));
		assertThat(result.year, is(lastMonth.get(Calendar.YEAR)));
	}
}