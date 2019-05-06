package tests;
 import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
 //import org.testng.asserts.*;

import pages.WFSignUpEmail;
import pages.WfLandingEmail;

//import static org.testng.Assert.assertEquals;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;


 
public class WFLandingPage extends BasePage {
	
	//WebDriver driver = new FirefoxDriver();
	
	
	//WFSignUpEmail WF = new WFSignUpEmail(driver);
	
	
	//banner text for incorrect email attempt
	//String Banner = WFSignUpEmail.BannerText().getText();
	
	//length of a typed value in email field
	//int email = WFSignUpEmail.EmailAddress().getAttribute("value").length();
	
 @Test //incorrect email string
  public void EmailSignIn() {
	 WfLandingEmail WFL = new WfLandingEmail(driver);
	 
	driver.get("https://walthamforest.gov.uk/");
	WFL.EmailAddress().click();
	WFL.EmailAddress().sendKeys("hello");
	driver.findElement(By.id("prefix-submitButton")).click();
	WFL.BannerText().getText();
	assertEquals(WFL.BannerText().getText(),"Please type a valid email address");
	 
	
  }
 


 @Test //incorrect email string
 public void EmailIncorrectStr() {
	 WfLandingEmail WFL = new WfLandingEmail(driver);
	 WFL.EmailAddress().clear();
	 WFL.EmailAddress().sendKeys("hello2");
	 driver.findElement(By.id("prefix-submitButton")).click();
	 driver.findElement(By.xpath("//div[@class='prefix-overlay-inner']//div[2]//div[2]//span[1]")).getText();
	 assertEquals(WFL.BannerText().getText(), "Please type a valid email address");
	
	 
	
 }

 
 @Test //string length typed in characters
 public void EmailMaxCharacters() {
	 WfLandingEmail WFL = new WfLandingEmail(driver);
	 WFL.EmailAddress().clear();
	 WFL.EmailAddress().sendKeys("1234567890");
	 assertEquals(WFL.EmailAddress().getAttribute("value").length(), 10);
		
 }
 
 
 @Test //string maxlength not set
 public void EmailMaxCharacterssetfield() {
	 WfLandingEmail WFL = new WfLandingEmail(driver);
	 WFL.EmailAddress().clear();
	 assertEquals(WFL.EmailAddress().getAttribute("maxlength"),null);
System.out.println(WFL.EmailAddress().getAttribute("maxlength"));
 
 }
 
 @Test
 public void Scroll() {
	 
	 
	 
 }
 }





 
