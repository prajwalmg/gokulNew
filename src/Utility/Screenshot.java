package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public void Screenshots(String string, WebDriver driver) {
		File img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// save the screenshot to the"screenshot" folder
		try {
			FileUtils.copyFile(img,
					new File(System.getProperty("user.dir") + "\\screenshot\\" + System.currentTimeMillis() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
