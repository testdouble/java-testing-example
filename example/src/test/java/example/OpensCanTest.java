package example;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import example.values.CannedWalrusFood;
import example.values.WalrusFood;

public class OpensCanTest {

	OpensCan subject = new OpensCan();

	@Test
	public void test() {
		WalrusFood food = new WalrusFood();
		CannedWalrusFood can = new CannedWalrusFood(food);

		WalrusFood result = subject.open(can);

		assertThat(result, is(food));
	}
}