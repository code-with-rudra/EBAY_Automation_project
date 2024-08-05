package CAPSTONE_PROJECT.Capstone_Project;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	WebDriver driver=null;
	
	@Test
	@Parameters("browser")
	public void invoke(String browser) throws IOException {
		FileInputStream fs = new FileInputStream("./Test Data/data.properties");
        Properties data = new Properties();
        data.load(fs);
 
        if (browser.toLowerCase().equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.toLowerCase().equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.toLowerCase().equals("firefox")) {
        	WebDriverManager.firefoxdriver().driverVersion("0.31.0").setup();
            driver = new FirefoxDriver();
        } else {
        	System.out.println("\nEnter chrome,edge or firefox only");
            throw new IllegalArgumentException("Invalid browser type: " + browser);
        }
 
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(data.getProperty("url"));
    }
}
