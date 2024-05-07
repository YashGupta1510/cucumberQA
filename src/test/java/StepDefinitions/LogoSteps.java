package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;

public class LogoSteps {
	WebDriver driver = null;
	LoginPage pg;
	@Given("user is on site")
	public void user_is_on_site() {
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		pg = new LoginPage(driver);
		pg.checkSiteOpen();
	}
	
	@Then("logo is visible")
	public void logo_is_visible() {
		pg.checkSiteOpen();
		driver.quit();
	}
}
