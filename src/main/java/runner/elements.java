package runner;

import org.openqa.selenium.By;

public class elements {
	By signup_full_name = By.xpath("//label[text()='Full Name']");
	By signup_Business_Name = By.xpath("//label[text()='Business Name']");
	By signup_Work_Email = By.xpath("//label[text()='Work Email']");
	By signup_Phone_Number = By.xpath("//label[text()='Phone Number']");
	By signup_Password = By.xpath("//label[text()='Password']");
	By signup_checkBox = By.xpath("//input[contains(@name,'CheckBox')]");
	By signup_createAccount = By.xpath("//button[text()='Create Account']");

	By login_email = By.xpath("//input[@name='email']");
	By login_password = By.xpath("//input[@name='password']");
	By login_signin = By.xpath("//div[contains(text(),'Sign In')]");

	By stripe_cardNumber = By.xpath("//input[contains(@id,'cardNumber')]");
	By stripe_cardExpiry = By.xpath("//input[contains(@id,'cardExpiry')]");
	By stripe_cardCvc = By.xpath("//input[contains(@id,'cardCvc')]");
	By stripe_billingName = By.xpath("//input[contains(@id,'billingName')]");
	By stripe_subscribe = By.xpath("//span[contains(text(),'Processing...')]");
	By stripe_back = By.xpath("//a[contains(@title,'Contus')]");
	
	By payment_ok = By.xpath("//button[contains(text(),'OK')]");	
}
