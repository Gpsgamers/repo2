package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class test_step extends elements {
	public WebDriver driver;
	public Select sel;
	public void signup(String email) {
		driver.findElement(signup_full_name).sendKeys(email);
		driver.findElement(signup_Business_Name).sendKeys(email);
		driver.findElement(signup_Work_Email).sendKeys(email);
		driver.findElement(signup_Phone_Number).sendKeys("1234567890");
		driver.findElement(signup_Password).sendKeys("Welcome@123");
		driver.findElement(signup_checkBox).click();
		driver.findElement(signup_createAccount).click();
	}

	public void emailVerification(String email) {
		driver.findElement(By.xpath("//span[@title='Click to Edit']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(email);
		driver.findElement(By.xpath("//button[text()='Set']")).click();
		sel = new Select(driver.findElement(By.xpath("//select[@id='gm-host-select']")));   
		sel.selectByVisibleText("guerrillamail.com");
		driver.findElement(By.xpath("//td[contains(text(),'Welcome to OnTheFly')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Activate Account')]")).click();
	}
}
