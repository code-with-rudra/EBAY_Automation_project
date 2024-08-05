package CAPSTONE_PROJECT.Capstone_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbaySignout {
	 WebDriver driver = null;

	    By UserAccount=By.id("gh-ug"); 
	    By Signout = By.xpath("//a[normalize-space()='Sign out']");
	    
	    public EbaySignout(WebDriver driver) {
	        this.driver = driver;
	    }

	    public WebElement UserAccount() {
	        return driver.findElement(UserAccount);
	    }
	    public WebElement Signout() {
	        return driver.findElement(Signout);
	    }
}

