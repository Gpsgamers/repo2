package com.test_resource;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.cli.Main;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Runner {
	public static WebDriver driver;
	public test_step method = new test_step();
	public static List<String> mail;
	public int planid;

	@Given("generate email")
	public void generate_email() {
		mail = method.email1();
	}

	@When("signup")
	public void signup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://onthefly-qa.contus.us/register");
		method.signup(driver, mail.get(1));
	}

	@Then("verify email")
	public void verify_email() {
		String current = driver.getWindowHandle();
		method.emailVerification(new ChromeDriver(), mail.get(0));
		driver.switchTo().window(current);
		driver.navigate().refresh();
		method.logout(driver);
	}

	@Given("set the credential to current plan {int} and {string} with {int}")
	public void set_the_credential_to_current_plan_and_with(Integer int1, String string, Integer int2) {
		if(int2 == 1 && int1 != 1 ) {
			method.change_plan_marketing_site(driver, int1,string,"login",mail);
		}else {
			System.out.println("plantype 1");
		}
	}

	@And("choose the plan {int} and {string}")
	public void choose_the_plan_and(Integer int1, String string) {
	    String link = "https://onthefly-qa.contus.us/register?planid="+int1+"&mode="+string;
	    driver.get(link);
	    driver.findElement(method.signup_login).click();
	}

	@When("login")
	public void login() {
		method.login(driver, mail.get(1), "Welcome@123");
	}

	@Then("page navigation {string}")
	public void page_navigation(String string) {
		if (driver.getCurrentUrl().contains(string)) {

		}
	}

}
