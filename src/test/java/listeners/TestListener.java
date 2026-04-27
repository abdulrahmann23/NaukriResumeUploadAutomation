package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Utils.ScreenshotUtil;

public class TestListener implements ITestListener {


	@Override
	public void onTestFailure(ITestResult result) {

        WebDriver driver = (WebDriver) result.getAttribute("driver");

        String testName = result.getName();

        ScreenshotUtil.capture(driver, testName);

        System.out.println("Screenshot captured for failed test: " + testName);
    }
}
