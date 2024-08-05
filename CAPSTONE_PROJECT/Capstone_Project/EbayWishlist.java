package CAPSTONE_PROJECT.Capstone_Project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EbayWishlist {

	   
    WebDriver driver;

    @FindBy(xpath = "//button[@id='watchBtn_btn_1']")
    WebElement wishCheck;

    @FindBy(xpath = "//a[@title='Watchlist']")
    WebElement wishList;
    
    public EbayWishlist(WebDriver driver) {
        this.driver = driver;
        // Initialize elements using PageFactory
        PageFactory.initElements(driver, this);
    }

    public void wishCheck() {
       wishCheck.click();
   }
    public WebElement wishClick() {
    	return wishList;
    	}
    
    public WebElement waitForWishList(int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(wishList));
    }
}
