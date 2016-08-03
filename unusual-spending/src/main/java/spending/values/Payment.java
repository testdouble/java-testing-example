package spending.values;

import java.math.BigDecimal;

public class Payment {

	public final Category category;
	public final BigDecimal price;
	public final String description;

	public Payment(Category category, BigDecimal price, String description) {
		this.category = category;
		this.price = price;
		this.description = description;
	}

}
