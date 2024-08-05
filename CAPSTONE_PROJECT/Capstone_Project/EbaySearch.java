package CAPSTONE_PROJECT.Capstone_Project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbaySearch {
	WebDriver driver = null;

	By search = By.xpath("//input[@id='gh-ac']");
	By inputtext=By.id("gh-btn");
	By product=By.xpath("//img[@alt='Callaway Diablo Edge 6 Hybrid RH Senior Flex Graphite 30°']");
	
	public EbaySearch(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement search() {
		return driver.findElement(search);
	}
	
	public WebElement inputtext() {
		return driver.findElement(inputtext);
	}
	public WebElement product() {
		return driver.findElement(product);
	}
	

}
