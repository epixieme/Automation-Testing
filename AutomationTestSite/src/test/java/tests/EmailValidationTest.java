package tests;
 import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



import java.util.List;
import java.util.Objects;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.BaseStream;
import java.util.stream.Stream;

import pages.APEmailAuthenticationPage;
import pages.ApWebsiteLandingpage;


 
public class EmailValidationTest extends TestBase {
	
 @Test //validate the sign in button navigates to the correct page
  public void SignUp() {
	 ApWebsiteLandingpage AP = new ApWebsiteLandingpage(driver);
	//Given
	//When
	 AP.EmailSignIn().click();
	String emailpagetitle = (driver.getTitle());
	System.out.println(emailpagetitle);
	//Then
	assertEquals(emailpagetitle, "Login - My Store");
	
	

	}
 
 @Test
 public void registervalidemail() {
	 ApWebsiteLandingpage AP = new ApWebsiteLandingpage(driver);
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
		EAP.CreateAccount().click();
		String EmailWarningMessage1 = (EAP.InvalidEmailAddress().getText());
		assertTrue(EmailWarningMessage1.contains("Invalid email address."));
		

		
 }
 
 @Test
 public void emailalreadyregistered() {
	 
	 APEmailAuthenticationPage EAP = new APEmailAuthenticationPage(driver);
		EAP.EmailAddress().sendKeys("kirstie.l.hayes@googlemail.com");
		String emailvalue = EAP.EmailAddress().getAttribute("value");
		System.out.println(emailvalue);
		EAP.CreateAccount().click();
		String EmailWarningMessage2 = (EAP.EmailAddressExists().getText());
		assertTrue(EmailWarningMessage2.contains("An account using this email address has already been registered. Please enter a valid password or request a new one."));
		}
	
 @Test
 public void AllRadioButtonBeforeselection() {
	 //needs to be finished and added to page
	 ApWebsiteLandingpage AP = new ApWebsiteLandingpage(driver);
	 AP.EmailSignIn().click();
	 APEmailAuthenticationPage EAP = new APEmailAuthenticationPage(driver);
		int random = (int)(Math.random() * 50 + 1);
		EAP.EmailAddress().sendKeys("testuser" + random + "@gmail.com");
		String emailvalue = EAP.EmailAddress().getAttribute("value");
		System.out.println(emailvalue);
		EAP.CreateAccount().click();
		
		
  // printing the text of radio button
		List<WebElement> radioButtons = EAP.AllRadioButtons();
		
		for(int i=0;i<radioButtons.size();i++){
			
	   //get label text
		//System.out.println(radioButtons.get(i).getText());
		
		
		//assertTrue(anyMatch);
			
		//count of radio button
		assertEquals(radioButtons.size(), 2);
						
						
		//isdisplayed should be true
	      
		assertTrue(radioButtons.get(i).isDisplayed());
			
			
		//isenabled should be true
		      
		assertTrue(radioButtons.get(i).isEnabled());
				
				
				
		//Isselected should be false
				
		assertFalse(radioButtons.get(i).isDisplayed());
					
		}
		
		boolean anyMatch = radioButtons.stream()
				.map(WebElement::getText)
				.filter(Objects::nonNull)
				.map(String::trim)
				.anyMatch(text ->"blunderbus".equals(text));
		
		System.out.println("anymatch results" + anyMatch);	
	
						
}
 
 
@Test
public void radioButtonMrSelection() {
	 ApWebsiteLandingpage AP = new ApWebsiteLandingpage(driver);
	 AP.EmailSignIn().click();
	 APEmailAuthenticationPage EAP = new APEmailAuthenticationPage(driver);
		int random = (int)(Math.random() * 50 + 1);
		EAP.EmailAddress().sendKeys("testuser" + random + "@gmail.com");
		String emailvalue = EAP.EmailAddress().getAttribute("value");
		System.out.println(emailvalue);
		EAP.CreateAccount().click();
		
		//click on the mr radio button
		EAP.Mrradiobutton().click();
		boolean Mrradiobttnselect = EAP.Mrradiobutton().isSelected();
		boolean Msradiobttnnotselect = EAP.Msradiobutton().isSelected();
		assertTrue(Mrradiobttnselect);
		assertFalse(Msradiobttnnotselect);
		
		//click on the mrs radio button
		EAP.Msradiobutton().click();
		boolean Mrradiobttnnotselect = EAP.Mrradiobutton().isSelected();
		boolean Msradiobttnselect = EAP.Msradiobutton().isSelected();
		assertFalse(Mrradiobttnnotselect);
		assertTrue(Msradiobttnselect);
		
			
}
		

@Test
public void radioButtonMrsSelection () {
	
	
	}
}
 
		

		
		
		

			
 

 
/* public void SelectDateofBirth() {
	 
	Select DateSelect = new Select(driver.findElement(By.name("")));
	DateSelect.selectByValue("");
 }*/

 





 
