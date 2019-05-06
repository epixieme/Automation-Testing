package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class APSearchPage {

	WebDriver driver;
	
	//****constructor****
		public APSearchPage(WebDriver driver) {
			this.driver=driver;
			
			
	//****initialise elements****	
	PageFactory.initElements(driver,this);
	
	}
	
//****locators****
		
//Text showing product results found on page
		
	@FindBy(xpath="//span[@class='heading-counter']")
	WebElement ProductCountresults;
				
//Text showing Count of products on page 1 - >1
					
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div[2]")
	WebElement ProductCountTxt;
	
//Actual Number of products displayed after a search by UL
	@FindBy(xpath="//*[@class='product_list grid row']")
	WebElement Productulsize;
					
//****Methods to access the webelement from Test Classes***
	public WebElement ProductResults() {
	return ProductCountresults;
	}
	public WebElement ProductCount() {
	return ProductCountTxt;
					}
	public WebElement Displayedproducts() {
		return Productulsize;				
	}
				}

