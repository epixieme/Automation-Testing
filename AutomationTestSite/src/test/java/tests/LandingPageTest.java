package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import pages.ApWebsiteLandingpage;

public class LandingPageTest extends TestBase {


	
	@Test
	public void APLogoDimensions() {
	ApWebsiteLandingpage LandingPage = new ApWebsiteLandingpage(driver);
	//image is displayed?
	boolean logopresent = LandingPage.websiteLogo().isDisplayed();
	
	int logowidth = LandingPage.websiteLogo().getSize().getWidth();
	int logoheight = LandingPage.websiteLogo().getSize().getHeight();
	System.out.println("Width = "+ logowidth + "Height is " + logoheight);
	
	assertEquals(logowidth, 350);
	assertEquals(logoheight,99);
	assertTrue(logopresent);
	
	
}
	

}
