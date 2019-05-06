package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class APEmailAuthenticationPage {
	
	WebDriver driver;
	public APEmailAuthenticationPage(WebDriver driver) {
		
		
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}
	
	//email address field box
	@FindBy (id="email_create")
	WebElement emailaddressfield;
	
    //email address create button
	@FindBy (xpath="//form[@id='create-account_form']//span[1]")
	WebElement CreateAcc;
	
	
	public WebElement EmailAddress(){
		
	return 	emailaddressfield;
		
	}
	
	public WebElement CreateAccount(){
		
		return 	CreateAcc;
			
		}
	//form[@id='create-account_form']//span[1]
	
	

}
