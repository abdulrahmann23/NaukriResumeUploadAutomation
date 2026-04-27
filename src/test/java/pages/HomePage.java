package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	
	private By profileLink =By.xpath("//a[@href='/mnjuser/profile']");
	
	public HomePage(WebDriver driver) {
        this.driver = driver;
    }
	
	public void goToProfile() {
        driver.findElement(profileLink).click();
    }
	
	public boolean isProfileLinkDisplayed() {
        return driver.findElement(profileLink).isDisplayed();
    }
}
