package StepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddToCartPage;
import pages.BaseClass;


public class AddToCartSteps extends BaseClass{
	
	AddToCartPage atc;

		@Given("user is on homepage")
		public void user_is_on_homepage() {
			Hooks h = new Hooks();
			driver = h.getDriver();
			atc = new AddToCartPage(driver);
		    atc.user_is_on_homepage();
		}

		@Given("user searched for {string}")
		public void user_searched_for(String product) {
			atc.user_searched_for(product);
		}
		@When("user clicked on add to cart button")
		public void user_clicked_on_add_to_cart_button() {
			 atc.user_clicked_on_add_to_cart_button();
		}
		@Then("cart item count should increase")
		public void cart_item_count_should_increase() {
			atc.cart_item_count_should_increase();
			driver.quit();
		}



}
