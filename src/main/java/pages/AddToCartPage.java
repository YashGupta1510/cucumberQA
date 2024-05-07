package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddToCartPage extends BaseClass{
	WebDriver driver;
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(id = "nav-logo-sprites")
	WebElement logo;
	
	@FindBy(css = "input[id=\"twotabsearchtextbox\"]")
	WebElement searchBar;
	
	@FindBy(css = "button[id =\"a-autoid-1-announce\"]")
	WebElement addToCartButton;
	
	@FindBy(css = "span[id =\"nav-cart-count\"]")
	WebElement cartItemCount;
	
	int initialCount;
	
	public void user_is_on_homepage() {
		Assert.assertTrue(logo.isDisplayed());
	}

	public void user_searched_for(String product) {
	    searchBar.sendKeys(product);
	    searchBar.sendKeys(Keys.ENTER);
	}

	public void user_clicked_on_add_to_cart_button() {
	    initialCount = Integer.parseInt((cartItemCount).getText());
	    addToCartButton.click();
	    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElement(addToCartButton,"Add to cart"));
	}
	
	public void cart_item_count_should_increase() {
		int finalCount = Integer.parseInt((cartItemCount).getText());
		Assert.assertEquals(finalCount, initialCount + 1);
	}

}
