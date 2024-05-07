package StepDefinitions;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseClass;
import pages.LoginPage;

public class LoginSteps extends BaseClass {
	
	private LoginPage loginPg;
	
	@Given("user is on Login Page")
	public void user_is_on_login_page() {
		Hooks h = new Hooks();
		driver = h.getDriver();
		loginPg = new LoginPage(driver);
		loginPg.checkSiteOpen();
		loginPg.navigateToLoginPage();
		
	}

	@When("user enter username {string}")
	public void user_enter_username(String email) {
	   loginPg.enterUsername(email);
	}

	@When("user enter password {string}")
	public void user_enter_password(String pwd) {
		loginPg.enterPwd(pwd);
	}

	@Then("user moves to solve page")
	public void user_moves_to_solve_page() {
	    loginPg.checkSolveMessage();
	    driver.quit();
	}
	
	@Then("user gets error")
	public void user_gets_error() {
	    loginPg.checkInvalidMsg();
	    driver.quit();
	}

}
