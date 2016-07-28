package example;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import example.values.CannedWalrusFood;
import example.values.Walrus;
import example.values.WalrusFood;

public class Stepdefs {
	Walrus walrus;
	WalrusFood food;
	CannedWalrusFood cannedFood;
	
	@Given("^I have a walrus$")
	public void i_have_a_walrus() throws Throwable {
	    walrus = new Walrus();
	}
	
	@Given("^I have food$")
	public void i_have_food() throws Throwable {
		food = new WalrusFood();
	}
	
	@Given("^I put the food in a can$")
	public void i_put_the_food_in_a_can() throws Throwable {
	    cannedFood = new CannedWalrusFood(food);
	}

	@When("^I have not fed the walrus$")
	public void i_have_not_fed_the_walrus() throws Throwable {
		// Do nothing
	}
	
	@When("^I have fed the walrus$")
	public void i_have_fed_the_walrus() throws Throwable {
	    walrus.addToStomach(food);
	}
	
	@When("^I feed the walrus canned food$")
	public void i_feed_the_walrus_canned_food() throws Throwable {
	    new FeedsWalrus().feed(walrus, cannedFood);
	}

	@Then("^the walrus's stomach should not contain any food I pass it$")
	public void the_walrus_s_stomach_should_not_contain_any_food_I_pass_it() throws Throwable {
		assertThat(walrus.hasEaten(food), is(false));
	}


	@Then("^the walrus's stomach should contain the food$")
	public void the_walrus_s_stomach_should_contain_the_food() throws Throwable {
		assertThat(walrus.hasEaten(food), is(true));
	}

	
}
