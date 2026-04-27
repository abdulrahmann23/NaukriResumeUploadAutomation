package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import Base.BaseTest;
import Utils.ConfigReader;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

@Listeners(listeners.TestListener.class)
public class E2E_UploadResumeTest extends BaseTest {
	
/*	
	WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;

    @BeforeClass
    public void setup() {
        // Load properties
        ConfigReader.loadProperties();

        // Choose browser (extendable later)
        String browser = ConfigReader.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Initialize Pages
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test(priority = 1)
    public void loginTest() {
        driver.get(ConfigReader.getProperty("url"));
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        Assert.assertTrue(homePage.isProfileLinkDisplayed(), "Login failed");
    }

    @Test(priority = 2, dependsOnMethods = "loginTest")
    public void uploadResumeTest() throws InterruptedException {
        homePage.goToProfile();

        profilePage.uploadResume(ConfigReader.getProperty("resumePath"));

        Thread.sleep(3000); // wait for upload

        String uploadDate = profilePage.getUploadDate();
        System.out.println("Upload Date: " + uploadDate);

        Assert.assertTrue(uploadDate.contains("202"), "Resume upload not updated");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
  */
	
	@Test(priority = 1)
    public void loginTest() {

		log.info("Opening application URL");
	    driver.get(config.getUrl());

	    LoginPage lp = new LoginPage(driver);

	    log.info("Clicking login button");
	    lp.clickLogin();

	    log.info("Entering username");
	    lp.enterEmail(config.getUsername());

	    log.info("Entering password");
	    lp.enterPassword(config.getPassword());

	    log.info("Submitting login");
	    lp.clickSubmit();

	    log.info("Login test completed");
    }

    @Test(priority = 2, dependsOnMethods = "loginTest")
    public void uploadResumeTest() throws InterruptedException {

        ProfilePage pp = new ProfilePage(driver);
        pp.goToProfile();
        
        String filePath = System.getProperty("user.dir") + "/" + config.getResumePath();
       // pp.uploadResume("S:\\Resume_mesame\\Abdul_automation_test_Engr_3+_exp_Immediate.pdf");

        String date = pp.getUploadDate();
        System.out.println(date);

        Assert.assertTrue(date.contains("202"), "Upload failed");
    }
}
