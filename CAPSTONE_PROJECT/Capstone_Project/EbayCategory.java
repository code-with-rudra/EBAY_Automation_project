package CAPSTONE_PROJECT.Capstone_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayCategory {
	WebDriver driver=null;
	
	By Motors = By.linkText("Motors");
	By categories=By.id("gh-shop-a");
	By catName=By.linkText("Sporting goods");

	
	public EbayCategory(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement categories() {
		return driver.findElement(categories);
	}
	public WebElement catName() {
		return driver.findElement(catName);
	}
	public WebElement Motors() {
		return driver.findElement(Motors);
	}
	
}
