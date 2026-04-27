package Utils;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;


public class ScreenshotUtil {

	public static void capture(WebDriver driver, String testName) {
	    try {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        String fileName = testName + "_" + System.currentTimeMillis() + ".png";

	        File dest = new File(System.getProperty("user.dir") + "/screenshots/" + fileName);

	        // Create folder if not exists (VERY IMPORTANT for Jenkins)
	        dest.getParentFile().mkdirs();

	        FileUtils.copyFile(src, dest);

	        System.out.println("Screenshot saved at: " + dest.getAbsolutePath());

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
