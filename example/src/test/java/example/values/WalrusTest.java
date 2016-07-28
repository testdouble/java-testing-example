package example.values;

import org.junit.*;

import example.values.Walrus;
import example.values.WalrusFood;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class WalrusTest {

	Walrus subject = new Walrus();

	@Test
	public void wrongFood() {
		WalrusFood someFood = new WalrusFood();
		WalrusFood moreFood = new WalrusFood();

		subject.addToStomach(someFood);

		assertThat(subject.hasEaten(moreFood), is(false));
	}

	@Test
	public void rightFood() {
		WalrusFood food = new WalrusFood();

		subject.addToStomach(food);

		assertThat(subject.hasEaten(food), is(true));
	}
}