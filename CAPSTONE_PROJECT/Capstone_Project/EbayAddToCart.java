package CAPSTONE_PROJECT.Capstone_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayAddToCart {
	 WebDriver driver = null;

	    By AddToCart=By.xpath("//span[contains(text(),'Add to cart')]");
	    		
	    public EbayAddToCart(WebDriver driver) {
	        this.driver = driver;
	    }

	    public WebElement AddToCart() {
	        return driver.findElement(AddToCart);
	    }
}
