package spending.values;

import java.math.BigDecimal;

public class BigSpend {

	public final BigDecimal actualSpending;
	public final BigDecimal usualSpending;
	public final Category category;

	public BigSpend(BigDecimal actualSpending, BigDecimal usualSpending, Category category) {
		this.actualSpending = actualSpending;
		this.usualSpending = usualSpending;
		this.category = category;
	}

}
