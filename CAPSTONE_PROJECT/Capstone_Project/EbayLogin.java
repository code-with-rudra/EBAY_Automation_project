package CAPSTONE_PROJECT.Capstone_Project;

import CAPSTONE_PROJECT.Capstone_Project.EbayReadExcel;  // Import statement for readexcel class

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EbayLogin extends BaseClass {
//	WebDriver driver=null;

	public static ExtentTest test; 
	public static ExtentReports report;
	private List<String> excelData;
	 
	@BeforeClass 
	public static void startTest() { 
	      report = new ExtentReports("./target/ExtentReportResults.html");
	      test = report.startTest("ExtentEbay"); 
	}
	
	@Test
	public void setup() throws FileNotFoundException {
	    EbayReadExcel reader = new EbayReadExcel();
	    excelData = reader.readData("./Test Data/Automation_Data.xlsx");
	}
	  
	@Test
    public void invoke()   {  
      test.log(LogStatus.PASS, "Navigated to the URL page Successfully");
    }
	
	@Test(dependsOnMethods = "invoke")
	public void login() throws IOException, InterruptedException {
		
	    FileInputStream fs = new FileInputStream("./Test Data/data.properties");
		Properties data = new Properties();
		data.load(fs);
			
		EbayLoginPage eLogin = new EbayLoginPage(driver);
		eLogin.email().sendKeys(data.getProperty("email"));
		eLogin.next().click();
		eLogin.password().sendKeys(data.getProperty("password"));
		eLogin.login().click();
//		driver.findElement(By.id("passkeys-cancel-btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(1000);
		ScreenShots("Home Page");
	
        test.log(LogStatus.PASS, "Navigated to the specified URL and Login Successful!");
	}
	  
    @Test(dependsOnMethods = "login")
  	public void Category() throws IOException, InterruptedException {
  		
        FileInputStream fs = new FileInputStream("./Test Data/data.properties");
  	    Properties data = new Properties();
  	    data.load(fs);
  			
		EbayCategory eCat=new EbayCategory(driver);		
	    Thread.sleep(1000);
		eCat.Motors().click();
	    Thread.sleep(1000);
		ScreenShots("Motors");
	    driver.navigate().back();
	    
        test.log(LogStatus.FAIL, "This Page isn't Working");

		eCat.categories().click();
		eCat.catName().click();
		
        test.log(LogStatus.PASS, "Successfully Navigated to the specified category Page");
    }
     
    @Test(dependsOnMethods = "Category")
    public void Search() throws IOException, InterruptedException {
    		
    	FileInputStream fs = new FileInputStream("./Test Data/data.properties");
    	Properties data = new Properties();
    	data.load(fs);
		EbaySearch esearch = new EbaySearch(driver);
        esearch.search().sendKeys(excelData.get(0)); 
        
//		esearch.search().sendKeys(data.getProperty("search"));
		esearch.inputtext().click(); 	    
	    esearch.product().click();
	    
        test.log(LogStatus.PASS, "Successfully Navigated to the product page");

	    ArrayList<String> lst=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(lst.get(1));
		Thread.sleep(1000);
		ScreenShots("Product");
    }
       
    @Test(dependsOnMethods = "Search")
    public void Wishlist() throws IOException, InterruptedException {
         
    	FileInputStream fs = new FileInputStream("./Test Data/data.properties");
        Properties data = new Properties();
    	data.load(fs);
	    EbayWishlist elist = new EbayWishlist(driver);
	    
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,150)");
	    
		elist.wishCheck();
		Thread.sleep(1500);
		ScreenShots("WishCheck");

        test.log(LogStatus.PASS, "Successfully Added to wacthlist");

		js.executeScript("window.scrollBy(0,-150)");
		
		WebElement wishListElement = elist.waitForWishList(10);

		// Now you can interact with the wishListElement
		wishListElement.click();
		Thread.sleep(1000);
		ScreenShots("WishList");

        test.log(LogStatus.PASS, "Watchlist updated");

		driver.navigate().refresh();
			
		js.executeScript("window.scrollBy(0,150)");
    }
        
    @Test(dependsOnMethods = "Wishlist")
    public void Addtocart() throws IOException, InterruptedException {
    		
    	FileInputStream fs = new FileInputStream("./Test Data/data.properties");
    	Properties data = new Properties();
    	data.load(fs);
	    EbayAddToCart ecart = new EbayAddToCart(driver);
	    ecart.AddToCart().click();
		ScreenShots("AddToCart");
	    Thread.sleep(1000);
	    
        test.log(LogStatus.PASS, "Successfully added to Cart and Navigated to the Cart");
        test.log(LogStatus.PASS, "Cart updated");
    }
     
    @Test(dependsOnMethods = "Addtocart")
    public void Signout() throws IOException, InterruptedException {
    		
    	FileInputStream fs = new FileInputStream("./Test Data/data.properties");
    	Properties data = new Properties();
    	data.load(fs);
	    EbaySignout esignout = new EbaySignout(driver);
	    esignout.UserAccount().click();
	    Thread.sleep(2000);
	    
		ScreenShots("Signout");

	    esignout.Signout().click();
		Thread.sleep(2000);
		
        test.log(LogStatus.PASS, "Signout Successfully");
    }
	
	public void ScreenShots(String name) throws IOException {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("./Screenshots/"+name+System.currentTimeMillis()+".png"));
		System.out.println("Screenshot Successfully added to Images");
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
	    if (driver != null) {  // Check if driver is not null before using it
	        Thread.sleep(1000);
	        driver.quit();
	    }
	}
	 
	@AfterClass
	public static void endTest() { 
	      report.endTest(test);
	      report.flush();
	}
}