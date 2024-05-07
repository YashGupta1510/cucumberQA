package StepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BaseClass;

public class Hooks extends BaseClass{
	
	@Before
	public void setup() {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	@After
	public void tearDown() {
		driver.quit();
	}

}
