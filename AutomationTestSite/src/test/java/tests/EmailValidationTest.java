package tests;
 import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
 //import org.testng.asserts.*;
import java.util.Random;

import pages.APEmailAuthenticationPage;
import pages.ApWebsiteLandingpage;

//import static org.testng.Assert.assertEquals;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;


 
public class EmailValidationTest extends TestBase {
	
 @Test //validate the sign in button navigates to the correct page
  public void SignUp() {
	 ApWebsiteLandingpage AP = new ApWebsiteLandingpage(driver);
	//Given
	 driver.get("http://automationpractice.com/index.php");
	//When
	 AP.EmailSignIn().click();
	String emailpagetitle = (driver.getTitle());
	System.out.println(emailpagetitle);
	//Then
	assertEquals(emailpagetitle, "Login - My Store");;
	
	

	}
 
 @Test
 public void registervalidemail() {
	 ApWebsiteLandingpage AP = new ApWebsiteLandingpage(driver);
	 driver.get("http://automationpractice.com/index.php");
	 AP.EmailSignIn().click();
	 APEmailAuthenticationPage EAP = new APEmailAuthenticationPage(driver);
		int random = (int)(Math.random() * 50 + 1);
		EAP.EmailAddress().sendKeys("testuser" + random + "@gmail.com");
		String emailvalue = EAP.EmailAddress().getAttribute("value");
		System.out.println(emailvalue);
		EAP.CreateAccount().click();
		String createaccount = (driver.getTitle());
		System.out.println(createaccount);
		assertEquals(createaccount, "Login - My Store");		
 }
 
 @Test
 public void invalidemail() {
	 
	 APEmailAuthenticationPage EAP = new APEmailAuthenticationPage(driver);
		int random = (int)(Math.random() * 50 + 1);
		EAP.EmailAddress().sendKeys("testuser@" + random + "@gmail.com");
		String emailvalue = EAP.EmailAddress().getAttribute("value");
		System.out.println(emailvalue);
		
		//add rest of test
		
 }
 
 @Test
 public void emailalreadyregistered() {
	 
	 APEmailAuthenticationPage EAP = new APEmailAuthenticationPage(driver);
		EAP.EmailAddress().sendKeys("kirstie.l.hayes@googlemail.com");
		String emailvalue = EAP.EmailAddress().getAttribute("value");
		System.out.println(emailvalue);
		
		//add rest of test
		
 }
}
 





 
