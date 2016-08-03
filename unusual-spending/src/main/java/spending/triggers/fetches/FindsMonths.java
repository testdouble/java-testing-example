package spending.triggers.fetches;

import java.util.Calendar;
import java.util.GregorianCalendar;

import spending.values.Month;

public class FindsMonths {

	public Month thisMonth() {
		Calendar now = GregorianCalendar.getInstance();
		return new Month(now.get(Calendar.YEAR), now.get(Calendar.MONTH));
	}

	public Month lastMonth() {
		Calendar lastMonth = GregorianCalendar.getInstance();
		lastMonth.add(Calendar.MONTH, -1);
		return new Month(lastMonth.get(Calendar.YEAR), lastMonth.get(Calendar.MONTH));
	}

}
