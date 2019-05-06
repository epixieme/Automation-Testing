package tests;
 import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
 //import org.testng.asserts.*;

import pages.APSearchPage;
import pages.ApWebsiteLandingpage;

 
public class SearchFunctionValidationTest extends TestBase {
	
@Test //verifying the searchbox placeholder text is present and correct
public void placeholdertext() {

	ApWebsiteLandingpage AP = new ApWebsiteLandingpage(driver);		
		
	driver.get("http://automationpractice.com/index.php");
	String Searchboxtext = AP.Search().getAttribute("placeholder");
	System.out.println(Searchboxtext);
	assertEquals(Searchboxtext, "Search");
		
		}
	
 @Test  // clicking on button without input search characters, should output banner text
  public void SearchNoCharacters() {
	 ApWebsiteLandingpage AP = new ApWebsiteLandingpage(driver);
	//Given
	 driver.get("http://automationpractice.com/index.php");
	 //When
	AP.Searchbtn().click();
	 String enterKeyword = AP.bannertext().getText();
	 //Then
	assertTrue(enterKeyword.contains("Please enter a search keyword"));
	 
 
}
 
		
@Test //invalid input search characters should output return banner text
	  public void InValidCharacters() {
		 ApWebsiteLandingpage AP = new ApWebsiteLandingpage(driver);
		 //Given
		driver.get("http://automationpractice.com/index.php");
		//When
		AP.Search().sendKeys("asguiud");
		AP.Searchbtn().click();
		APSearchPage SP = new APSearchPage(driver);
		String NoResults = AP.bannertext().getText();
		//Then
		assertTrue(NoResults.contains("No results were found for your search"));
		String ProductCountResults = SP.ProductResults().getText();
		//Then
		assertTrue(ProductCountResults.contains("0 results have been found."));
		String SearchPgTitle = (driver.getTitle());
		//Then
		Assert.assertEquals(SearchPgTitle, "Search - My Store");
		
		}


@Test //valid input search characters should return search results
public void ValidCharacters() {
	 ApWebsiteLandingpage AP = new ApWebsiteLandingpage(driver);
	 //Given
	driver.get("http://automationpractice.com/index.php");
	//When
	AP.Search().sendKeys("dresses");
	AP.Searchbtn().click();
	APSearchPage SP = new APSearchPage(driver);
	String SearchPgTitle = (driver.getTitle());
	//Then
	Assert.assertEquals(SearchPgTitle, "Search - My Store");
	String ProductCountdisplayed = SP.ProductCount().getText();
	//Then
	assertTrue(ProductCountdisplayed.contains("Showing 1"));
    //Then
    WebElement ProductList = SP.Displayedproducts();
    List<WebElement> ProductsDisplayed = ProductList.findElements(By.xpath(".//ul"));
    System.out.println("List size is: " +ProductsDisplayed.size());
    Assert.assertEquals(ProductsDisplayed, 7);

	
 }

@Test //Ensure no maximum character limit set - alert banners should handle search inputs
public void searchboxmaxcharacters() {
	ApWebsiteLandingpage AP = new ApWebsiteLandingpage(driver);
	//Given
	driver.get("http://automationpractice.com/index.php");
	//When
    String searchmaxlength = AP.Search().getAttribute("maxlength");
	System.out.println(AP.Search().getAttribute("maxlength"));
	//Then
	assertEquals(searchmaxlength, null);
	
}

@Test //ensure no minimum character limit set  - alert banners should handle search inputs
public void searchboxmincharacters() {
	ApWebsiteLandingpage AP = new ApWebsiteLandingpage(driver);
	//Given
	driver.get("http://automationpractice.com/index.php");
	//When
    String searchminlength = AP.Search().getAttribute("minlength");
	System.out.println(AP.Search().getAttribute("minlength"));
	//Then
	assertEquals(searchminlength, null);}
	

@Test // simple test to see how interupt could produce an error. Could put this under a performance package or class
public void searchbuttonclicklimit () {
	ApWebsiteLandingpage AP = new ApWebsiteLandingpage(driver);
	//Given
	driver.get("http://automationpractice.com/index.php");
	//When
	AP.Search().sendKeys("dresses");
	
	for(int i=1;i<20;i++) {
	
	AP.Searchbtn().click();
	
	String SearchPgTitle = (driver.getTitle());
	//Then
		Assert.assertEquals(SearchPgTitle, "Search - My Store");	
	
	}
	
	
	
	//more tests to create
	
		
	//assert list only contains dresses
	
	//verify hover blur and focus - tool tip and peform

	
	}
}

	
	
	
	
	 


	 
 
 




 
