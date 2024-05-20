package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BaseClass;

public class Hooks extends BaseClass{
	
	@Before
	public void setup() {
		ChromeOptions opt = new ChromeOptions();
	
			opt.addArguments("--headless");
		
		driver = WebDriverManager.chromedriver().capabilities(opt).create();
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
