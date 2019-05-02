package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.BasePage;

public class WfLandingEmail /*extends BasePage*/ {

	WebDriver driver;
	
	public WfLandingEmail(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		//PageFactory.initElements(driver, this);
	
	}

	//email address for landing page pop up
		@FindBy(name="e")
		WebElement emailaddress;
		
		//banner text for incorrect email format for landing page pop up
		
		@FindBy(xpath=("//div[@class='prefix-overlay-inner']//div[2]//div[2]//span[1]"))
		WebElement bannertext;
		
		
	
		public WebElement EmailAddress(){
			return emailaddress;
		}
		
		public WebElement BannerText() {
			return bannertext;
		}

}
	