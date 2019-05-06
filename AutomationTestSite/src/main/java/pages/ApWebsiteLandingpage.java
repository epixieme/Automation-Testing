package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApWebsiteLandingpage {

	WebDriver driver;
	
//****constructor****
	public ApWebsiteLandingpage(WebDriver driver) {
		this.driver=driver;
		
		
//****initialise elements****	
PageFactory.initElements(driver,this);
		}
	
//****locators****
	//searchbox for landing page
		@FindBy(name="search_query")
		WebElement searchbox;
		
	//Button for searching
		@FindBy (name="submit_search")
		WebElement Searchbutton;
		
	//Banner text message when entering negative test searches
		@FindBy(xpath="//p[@class='alert alert-warning']")
		WebElement bannertxt;
		
	//email sign in button
		
		@FindBy (xpath="//*[@class='login']")
		WebElement EmailSign;
		
//****Methods to access the webelement from Test Classes***
	
		public WebElement Search(){
		return searchbox;
		}
		
		public WebElement bannertext() {
		return bannertxt;
		}
		public WebElement Searchbtn() {
			return Searchbutton;
		}
		
		public WebElement EmailSignIn() {
			return EmailSign;
		}
		
			
		//could have initalised page factory in each test so would have mitigated using return for accessing the object
			//could have used a public void method to pass the webdriver operations as below e.g
			
			//public void usersearch(String searchbox) {
			//searchbox.sendKeys(searchbox);
			//}
		//Selenium and page factory alternative model
		//https://www.toolsqa.com/selenium-webdriver/page-object-pattern-model-page-factory/
}
	