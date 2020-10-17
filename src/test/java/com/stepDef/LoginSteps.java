package com.stepDef;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pageFactory.LoginPageHRM;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginSteps {
WebDriver driver;

	

LoginPageHRM loginpageHRM;

@Given("^user open web browser and navigate to HRM login screen$")
	public void user_open_web_browser_and_navigate_to_HRM_login_screen() throws Throwable {
System.setProperty("webdriver.chrome.driver","C:\\Users\\MdAli\\Desktop\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");	
		driver.getTitle();
		
	}

	@Then("^user Navigate to Page and verify the Page Title is \"([^\"]*)\"$")
	public void user_Navigate_to_Page_and_verify_the_Page_Title_is(String arg1) throws Throwable {
	
		String actual=driver.getTitle();
		String expected="OrangeHRM";
		Assert.assertTrue("The Title is wrong", actual.contains(expected));
	
	
	}

	@Then("^user enter a valid username and password$")
	public void user_enter_a_valid_username_and_password() throws Throwable {

	}

	@Then("^user click the Sign in button$")
	public void user_click_the_Sign_in_button() throws Throwable {

	}

	@When("^user click on log out button for Orange Hrm$")
	public void user_click_on_log_out_button_for_Orange_Hrm() throws Throwable {

	}

}

