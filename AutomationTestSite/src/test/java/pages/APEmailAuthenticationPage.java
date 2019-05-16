package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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
	
	//email banner warning message invalid email address
		@FindBy (xpath="//li[contains(text(),'Invalid email address.')]")
		WebElement emailwarning1;
		
		
	//email banner warning message email address already exists
		@FindBy (xpath="//li[contains(text(),'An account using this email address has already be')]")
		WebElement emailwarning2;
		

	//Create accoount form password field
		@FindBy (id="passwd")
		WebElement CreatePassword;
		
	//Site logo
		
		@FindBy (xpath="//a[@class='header__logo']//img")
		WebElement Logo;
		
		//All checkboxes
		
	
		@FindBy(xpath = "//div[@class='radio-inline']")
		// name ="id_gender"
		List<WebElement> RadioGroup;
		
		
	//Mr checkbox
		@FindBy(id="id_gender1")
		WebElement mrradiobttn;
		
		//Mrs checkbox
		
		@FindBy (id="id_gender2")
		WebElement msradiobttn;
		
	
	
	public WebElement EmailAddress(){
		
	return 	emailaddressfield;
		
	}
	
	public WebElement CreateAccount(){
		
		return 	CreateAcc;
			
		}
	
	public WebElement InvalidEmailAddress(){
		
		return 	emailwarning1;
			
		}
public WebElement EmailAddressExists(){
		
		return 	emailwarning2;
			
		}


public WebElement EnterPassword(){
	
	return 	CreatePassword;
		
	}


public WebElement Mrradiobutton() {
return mrradiobttn;

}

public WebElement Msradiobutton() {
	
	return msradiobttn;
}

public List<WebElement> AllRadioButtons() {
	
	return RadioGroup;
}

}

