package spending.triggers.warns;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Collection;

import spending.values.BigSpend;

public class ComposesBody {

	public String compose(Collection<BigSpend> bigSpends) {
		StringBuilder sb = new StringBuilder();
		sb.append("Hello card user!\n\n");
		sb.append("We have detected unusually high spending on your card in these categories:\n\n");
		for (BigSpend bigSpend : bigSpends) {
			sb.append("* You spent ").append(toCurrency(bigSpend.actualSpending));
			sb.append(" on ").append(bigSpend.category.toString().toLowerCase());
			sb.append("\n");
		}
		sb.append("\nLove,\n\n");
		sb.append("The Credit Card Company");
		return sb.toString();
	}

	private String toCurrency(BigDecimal total) {
		return NumberFormat.getCurrencyInstance().format(total);
	}
}
