package com.stepDef;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.pageFactory.LoginPageHRM;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	WebDriver driver;

	LoginPageHRM object;

	@Given("^user open web browser and navigate to HRM login screen$")
	public void user_open_web_browser_and_navigate_to_HRM_login_screen() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MdAli\\Desktop\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		object = PageFactory.initElements(driver, LoginPageHRM.class);

	}

	@Then("^user Navigate to Page and verify the Page Title is \"([^\"]*)\"$")
	public void user_Navigate_to_Page_and_verify_the_Page_Title_is(String arg1) throws Throwable {

		String actual = driver.getTitle();
		String expected = "OrangeHRM";
		Assert.assertTrue("The Title is wrong", actual.contains(expected));

	}

	@Then("^user enter a valid username and password$")
	public void user_enter_a_valid_username_and_password() throws Throwable {

		object.getUsername().sendKeys("Admin");
		object.getPassword().sendKeys("admin123");
	}

	@Then("^user click the Sign in button$")
	public void user_click_the_Sign_in_button() throws Throwable {

		WebElement signin = driver.findElement(By.xpath("//*[@name='Submit']"));
		signin.click();
	}

	@When("^user click on log out button for Orange Hrm$")
	public void user_click_on_log_out_button_for_Orange_Hrm() throws Throwable {
		WebElement welcome = driver.findElement(By.xpath("//*[contains(text(),'Welcome')]"));
		welcome.click();
		WebElement logout = driver.findElement(By.xpath("//*[contains(text(),'Logout')]"));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1,TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(logout)).click();
		System.out.println("Hello Java- Test for new branch");
	}

}
