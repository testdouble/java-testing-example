package spending.triggers.warns;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Collection;

import spending.values.BigSpend;

public class ComposesSubject {

	public String compose(Collection<BigSpend> bigSpends) {
		BigDecimal total = new BigDecimal("0");
		for (BigSpend bigSpend : bigSpends) {
			total = total.add(bigSpend.actualSpending);
		}
		return "Unusual spending of " + toCurrency(total) + " detected!";
	}

	private String toCurrency(BigDecimal total) {
		return NumberFormat.getCurrencyInstance().format(total);
	}

}
