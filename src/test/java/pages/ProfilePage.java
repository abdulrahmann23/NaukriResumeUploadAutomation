package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
	
/*	
	WebDriver driver;

    private By resumeUploadInput = By.id("attachCV");
    private By uploadDateText = By.cssSelector(".updateOn");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void uploadResume(String filePath) {
        WebElement fileInput = driver.findElement(resumeUploadInput);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display = 'block';", fileInput);
        fileInput.sendKeys(filePath);
    }

    public String getUploadDate() {
        return driver.findElement(uploadDateText).getText();
    }
    */
	
	 WebDriver driver;

	    public ProfilePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    By profileLink = By.xpath("//a[@href='/mnjuser/profile']");
	    By fileInput = By.id("attachCV");
	    By uploadDate = By.cssSelector(".updateOn");

	    public void goToProfile() {
	        driver.findElement(profileLink).click();
	    }

	    public void uploadResume(String path) throws InterruptedException {
	        WebElement file = driver.findElement(fileInput);

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].style.display = 'block';", file);

	        file.sendKeys(path);
	        Thread.sleep(3000);
	    }

	    public String getUploadDate() {
	        return driver.findElement(uploadDate).getText();
	    }
}
