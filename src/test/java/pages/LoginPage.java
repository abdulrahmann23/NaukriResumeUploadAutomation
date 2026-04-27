package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage {

	/*
	WebDriver driver;
	 WebDriverWait wait;
	
	
	private By loginButton = By.xpath("//a[text()='Login']");
	private By emailField  = By.xpath("//input[@placeholder='Enter your active Email ID / Username']");
	private By passwordField = By.xpath("//input[@placeholder='Enter your password']");
    private By submitButton = By.xpath("//button[text()='Login']");
	
    
    public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	}
    
    public void login(String email, String password)
    { 
    	//driver.findElement(loginButton).click();
        //driver.findElement(emailField).sendKeys(email);
        //driver.findElement(passwordField).sendKeys(password);
        //driver.findElement(submitButton).click();
    	 wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
         wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
         driver.findElement(passwordField).sendKeys(password);
         driver.findElement(submitButton).click();
    }
    
  */  
	
	 WebDriver driver;
	    Logger log = LogManager.getLogger(LoginPage.class);

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void clickLogin() {
	        log.info("Clicking login link");
	        driver.findElement(By.id("login_Layer")).click();
	    }

	    public void enterEmail(String user) {
	        log.info("Typing email");
	        driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).sendKeys(user);
	    }

	    public void enterPassword(String pass) {
	        log.info("Typing password");
	        driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys(pass);
	    }

	    public void clickSubmit() {
	        log.info("Clicking submit button");
	        driver.findElement(By.xpath("//button[text()='Login']")).click();
	        

	    }
}
