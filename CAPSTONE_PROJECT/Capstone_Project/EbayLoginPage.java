package CAPSTONE_PROJECT.Capstone_Project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayLoginPage {
	WebDriver driver = null;

	By email = By.xpath("//input[@name='userid']");
	By next = By.xpath("//button[@id='signin-continue-btn']");
	By password = By.xpath("//input[@id='pass']");
	By login = By.xpath("//button[@id='sgnBt']");
	
	public EbayLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement email() {
		return driver.findElement(email);
	}
	public WebElement next() {
		return driver.findElement(next);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement login() {
		return driver.findElement(login);
	}
	

}