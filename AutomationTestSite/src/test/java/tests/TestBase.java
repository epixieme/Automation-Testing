//This page is the super class for driver lifecycle code ie any set up and teardown scripts for current and future tests

package tests;
 
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
 
public class TestBase {
WebDriver driver;
 
 // username and access key for browserstack
//public static String Username = "kirstiehayes1";
		 
		 
//public static String AccessKey = "Mt5qyS2ssRmJmGWtSypY";


 @BeforeClass
 public void initialize() throws IOException{
	 

	// DesiredCapabilities caps = new DesiredCapabilities();
	 
	// driver = new RemoteWebDriver(new URL("https://"+Username+":"+AccessKey+"@hub-cloud.browserstack.com/wd/hub"),DesiredCapabilities.firefox());
	 
	 //caps.setCapability("browser","Firefox");
	// caps.setCapability("browser_version","66.0 beta");
	// caps.setCapability("os","OS X");
	 //caps.setCapability("os_version","Mojave");
	 //caps.setCapability("resolution","1024x768");
	driver = new FirefoxDriver(); 


//Implicit wait for page to load
 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
 
//To open test website
                driver.get("http://automationpractice.com/index.php");
                
//To maximize browser
                driver.manage().window().fullscreen();
                      
               }

 
 @AfterClass
 //Test cleanup
 public void TeardownTest()
    {
     driver.quit();  //driver.quit();
     
    }
 
}
