package com.test_resource;

import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class test_step extends elements {
	//public WebDriver driver;
	public Select sel;
	public void signup(WebDriver driver,String email) {
		driver.findElement(signup_full_name).sendKeys(email);
		driver.findElement(signup_Business_Name).sendKeys(email);
		driver.findElement(signup_Work_Email).sendKeys(email);
		driver.findElement(signup_Phone_Number).sendKeys("1234567890");
		driver.findElement(signup_Password).sendKeys("Welcome@123");
		driver.findElement(signup_checkBox).click();
		driver.findElement(signup_createAccount).click();
	}

	public void emailVerification(String email,WebDriver driver2,String current) {
		WebDriver driver1 = new ChromeDriver();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver1.manage().window().maximize();
		driver1.get("https://www.guerrillamail.com/");
		driver1.findElement(By.xpath("//span[@title='Click to Edit']")).click();
		driver1.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(email);
		driver1.findElement(By.xpath("//button[text()='Set']")).click();
		sel = new Select(driver1.findElement(By.xpath("//select[@id='gm-host-select']")));   
		sel.selectByVisibleText("guerrillamail.com");
		driver1.findElement(By.xpath("//td[contains(text(),'Welcome to OnTheFly')]")).click();
		String link = driver1.findElement(By.xpath("//a[contains(text(),'Activate Account')]")).getAttribute("href");
		driver1.get(link);
		driver1.quit();
		driver2.switchTo().window(current);
	}
	
	public void login(WebDriver driver,String email,String password) {
		driver.findElement(login_email).sendKeys(email);
		driver.findElement(login_password).sendKeys(password);
		driver.findElement(login_signin).click();
	}
	
	public void logout(WebDriver driver) {
		driver.findElement(logout_profile).click();
		driver.findElement(logout_option).click();
		driver.findElement(logout_button).click();
	}
	
	public List email1(){
		 String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
		 String email = new String(); 
		 List mail = new ArrayList<String>();
		 int i;
		 while (email.length() < 18) { 
			 int index = (int)(AlphaNumericStr.length() * Math.random());
			 email =email+AlphaNumericStr.charAt(index);
		 }
		 mail.add(email);
		 mail.add(email+"@guerrillamail.com");
		 return mail;
	}
	
	public List<String> email() {
		String email_id = null ;
		String email = null;
		String count = null, count1=null;
		List<String> mail = new ArrayList<String>();
		try {
			Properties prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + ".\\configuration\\email.properties");
			prop.load(ip);
			email = prop.getProperty("email");
			String domain = prop.getProperty("domain");
			count = prop.getProperty("count");
			String attherate = prop.getProperty("attherate");
			ip.close();
			int num = Integer.parseInt(count);
			count1 = count;
			count = num+1+ "";
			FileOutputStream op = new FileOutputStream(".\\Configuration\\email.properties");
			prop.setProperty("count", count);
			prop.store(op, null);
			email_id = new String(email + num + attherate + domain);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mail.add(email+count1);
		mail.add(email_id);
		return mail;
	}
	public void payment(WebDriver driver) {
		driver.findElement(stripe_cardNumber).sendKeys("4242424242424242");
		driver.findElement(stripe_cardExpiry).sendKeys("12/27");
		driver.findElement(stripe_cardCvc).sendKeys("111");
		driver.findElement(stripe_billingName).sendKeys("contus");
		driver.findElement(stripe_subscribe).click();
		driver.findElement(payment_ok).click();
	}
	
	public void change_plan_marketing_site(WebDriver driver,int plan,String mode,String action, List<String> email_id) {
		String register_link = "https://onthefly-qa.contus.us/register?planid="+plan+"&mode="+mode;
		System.out.println(register_link);
		driver.navigate().to(register_link);;
		switch (action) {
		case "login":
			driver.findElement(signup_login).click();
			login(driver, email_id.get(1), "Welcome@123");
			payment(driver);
			break;
			
		case "register with emailverification":
			signup(driver, email_id.get(1));
			emailVerification(email_id.get(0),driver,driver.getWindowHandle());
			driver.navigate().refresh();
			logout(driver);
			break;
		
		case "register without emailverification":
			signup(driver, email_id.get(1));
			driver.manage().deleteAllCookies();
			break;

		default:
			System.out.println("param not passed");
			break;
		}
	}

	
}
