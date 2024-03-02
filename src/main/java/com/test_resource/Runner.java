package com.test_resource;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Runner {
	public static WebDriver driver;
	public test_step method = new test_step();
	public static List<String> mail;
	public static int current_planid;
	public Timeouts wait;
	public WebDriverWait wait1;
	public Actions act;
	@Given("generate email")
	public void generate_email() {
		mail = method.email1();
	}

	@When("signup")
	public void signup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		wait = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://onthefly-qa.contus.us/register");
		method.signup(driver, mail.get(1));
	}

	@Then("verify email")
	public void verify_email() {
		method.emailVerification(mail.get(0), driver, driver.getWindowHandle());
		driver.navigate().refresh();
		method.logout(driver);
	}

	@Given("set the credential to current plan {int} and {string} with {int}")
	public void set_the_credential_to_current_plan_and_with(Integer int1, String string, Integer int2) {
		if (int1 != 1 && int2 == 1) {
			method.change_plan_marketing_site(driver, int1, string, "login", mail);
			method.logout(driver);
			current_planid = int1;
		} else if (current_planid == 5 && int2 == 1) {
			driver.findElement(method.login_signup).click();
			mail = method.email1();
			method.signup(driver, mail.get(1));
			method.emailVerification(mail.get(0), driver, driver.getWindowHandle());
			driver.navigate().refresh();
			current_planid = 1;
			method.logout(driver);
		} else {
			System.out.println("current planid "+ int1);
		}
	}

	@And("choose the plan {int} and {string}")
	public void choose_the_plan_and(Integer int1, String string) {
		String link = "https://onthefly-qa.contus.us/register?planid=" + int1 + "&mode=" + string;
		driver.get(link);
		driver.findElement(method.signup_login).click();
	}

	@When("login")
	public void login() {
		method.login(driver, mail.get(1), "Welcome@123");
	}

	@Then("page navigation {string}")
	public void page_navigation(String string) throws InterruptedException, AWTException {
		Thread.sleep(6000);
		//WebElement until = wait1.until(ExpectedConditions.visibilityOfElementLocated(method.stripe_back));
		System.out.println(driver.getCurrentUrl().contains(".stripe."));
		System.out.println(driver.getCurrentUrl());
		act = new Actions(driver);
		if(driver.getCurrentUrl().contains(".stripe.")) {
			act.moveToElement(driver.findElement(method.stripe_back_mouse));
			driver.findElement(method.stripe_back).click();
			driver.findElement(method.payment_ok).click();
			method.logout(driver);
		}
			method.logout(driver);
	}

}
