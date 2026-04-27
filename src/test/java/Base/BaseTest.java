package Base;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import Utils.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class BaseTest {


	public WebDriver driver;
    public ConfigReader config;
    public static Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    public void setup() {

    	 config = new ConfigReader();

         log.info("Launching browser");

         driver = new ChromeDriver();

         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         log.info("Browser launched successfully");
    }

    @AfterClass
    public void tearDown() {
    	 log.info("Closing browser");
         driver.quit();
    }
    
    @AfterMethod
    public void setDriver(ITestResult result)
    {
    	result.setAttribute("driver", driver);
    }
}
