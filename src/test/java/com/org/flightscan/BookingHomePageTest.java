package com.org.flightscan;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.org.flightscan.base.TestBase;
import com.org.flightscan.pages.HomePage;
import com.org.flightscan.pages.LoginPage;
import com.org.flightscan.util.TestUtil;


    //Created object of testng SoftAssert class to use It's Properties.


public class BookingHomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	

	public BookingHomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Find a Flight: Mercury Tours:","Home page title not matched");
		
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
		
	}
	
	
	
	@Test(priority=3)

    public void selectDatesandBookFlights() {
		
     
		//Fill fromDate as dd/mm/yyyy as 19/01/2019

        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        WebElement fromDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        
        fromMonth.sendKeys("January");
        fromDay.sendKeys("19");
        

      //Fill toDate as dd/mm/yyyy as 26/01/2019

        WebElement toMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        
        toMonth.sendKeys("January");
        toDay.sendKeys("26"); 
        
        
        //find flights

        WebElement findFlights = driver.findElement(By.xpath("//input[@name='findFlights']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", findFlights);
    	
    	//select outflights
		
    	WebElement outFlight = driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$361$271$7:10']"));
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
    	js1.executeScript("arguments[0].click();", outFlight);
    	
    	//select inflights
	
    	WebElement inFlight = driver.findElement(By.xpath("//input[@value='Pangea Airlines$632$282$16:37']"));
        JavascriptExecutor js2 = (JavascriptExecutor)driver;
    	js2.executeScript("arguments[0].click();", inFlight);
    	
    	//select and reserveflights
	
    	WebElement reserveFlights = driver.findElement(By.xpath("//input[@name='reserveFlights']"));
        JavascriptExecutor js3 = (JavascriptExecutor)driver;
    	js3.executeScript("arguments[0].click();", reserveFlights);
    	
//   	assertTrue(driver.findElement(By.xpath("//font[contains(text(),'1/19/2018')]")).getText().contains("1/19/2019"));
//    	assertTrue(driver.findElement(By.xpath("//font[contains(text(),'1/26/2018')]")).getText().contains("1/26/2019"));
    	
    	
    	//Enter Passenger Details
    	
    	WebElement firstName = driver.findElement(By.xpath("//input[@name='passFirst0']"));
    	firstName.sendKeys("sam");
    	firstName.sendKeys(Keys.TAB);
    	
    	WebElement secondName = driver.findElement(By.xpath("//input[@name='passLast0']"));
    	secondName.sendKeys("sa");
    	secondName.sendKeys(Keys.TAB);
    	
    	WebElement creditnumber = driver.findElement(By.xpath("//input[@name='creditnumber']"));
    	creditnumber.sendKeys("0000000000");
    	creditnumber.sendKeys(Keys.TAB);
    	
    	//input[@name='buyFlights']
    	
    	WebElement buyFlights = driver.findElement(By.xpath("//input[@name='buyFlights']"));
        JavascriptExecutor js4 = (JavascriptExecutor)driver;
    	js4.executeScript("arguments[0].click();", buyFlights);
    	
   	//Confirmation Page 
  	
 
    		assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Nov 3, 2018')]")).getText().contains("currDate"));
    	
   	
	}
	
	
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}

	

}

