package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BaseClass {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "nav-logo-sprites")
	WebElement logo;
	
	@FindBy(id = "nav-link-accountList")
	WebElement loginPageTab;
	
	@FindBy(id = "ap_email")
	WebElement emailInput;
	
	@FindBy(css = "input[type=\"password\"]")
	WebElement pwdInput;
	
	@FindBy(css = "span[class=\"a-size-large\"]")
	WebElement solveMessage;
	
	@FindBy(css = "h4[class=\"a-alert-heading\"]")
	WebElement invalidEmailMsg;
	
	
	public void checkSiteOpen() {
		Assert.assertTrue(logo.isDisplayed());
		
	}
	
	public void navigateToLoginPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(loginPageTab));
		loginPageTab.click();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Amazon Sign In", "Sign in page Title assertion");
	}
	
	
	public void enterUsername(String email) {
		emailInput.sendKeys(email);
		emailInput.sendKeys(Keys.ENTER);
	}
	
	public void enterPwd(String pwd) {
		pwdInput.sendKeys(pwd);
		pwdInput.sendKeys(Keys.ENTER);
	}
	
	public void checkSolveMessage() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(solveMessage));
		String s = solveMessage.getText();
		Assert.assertEquals(s, "Solve this puzzle to protect your account");
	}
	
	public void checkInvalidMsg() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(invalidEmailMsg));
		String s = invalidEmailMsg.getText();
		Assert.assertEquals(s, "There was a problem");
	}
}
