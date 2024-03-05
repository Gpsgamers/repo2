package com.test_resource;

import org.openqa.selenium.By;

public class elements {
	By signup_full_name = By.xpath("//input[@id='name']");
	By signup_Business_Name = By.xpath("//input[@id='organisationNames']");
	By signup_Work_Email = By.xpath("//input[@id='emailID']");
	By signup_Phone_Number = By.xpath("//input[@id='phoneNum']");
	By signup_Password = By.xpath("//input[@id='password']");
	By signup_checkBox = By.xpath("//input[contains(@name,'CheckBox')]");
	By signup_createAccount = By.xpath("//button[text()='Create Account']");
	By signup_login = By.xpath("//*[text()='Sign In']");
	
	By login_email = By.xpath("//input[@label='email']");
	By login_password = By.xpath("//input[@name='password']");
	By login_signin = By.xpath("//div[contains(text(),'Sign In')]");
	By login_signup = By.xpath("//*[text()='Sign Up']");

	By stripe_cardNumber = By.xpath("//input[contains(@id,'cardNumber')]");
	By stripe_cardExpiry = By.xpath("//input[contains(@id,'cardExpiry')]");
	By stripe_cardCvc = By.xpath("//input[contains(@id,'cardCvc')]");
	By stripe_billingName = By.xpath("//input[contains(@id,'billingName')]");
	By stripe_billing_country = By.xpath("//select[@id='billingCountry']");
	By stripe_billing_addressline1 = By.xpath("//input[@id='billingAddressLine1']");
	By stripe_billing_addressline2 = By.xpath("//input[@id='billingAddressLine2']");
	By stripe_billing_locality = By.xpath("//input[@id='billingLocality']");
	By stripe_billing_billingPostalCode = By.xpath("//input[@id='billingPostalCode']");
	By stripe_state = By.xpath("//select[@id='billingAdministrativeArea']");
	By stripe_subscribe = By.xpath("//button[@type='submit']");
	By stripe_back_mouse = By.xpath("//a[contains(@title,'Contus')]");
	By stripe_back = By.xpath("//span[contains(text(),'Back')]");
	
	By payment_ok = By.xpath("//button[contains(text(),'OK')]");
	
	By logout_profile = By.xpath("//div[@class='profile_name']");
	By logout_option = By.xpath("//span[text()='Log Out']");
	By logout_button = By.xpath("//button[text()='Logout']");
}
