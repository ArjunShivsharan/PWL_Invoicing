package com.org.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	// Screenshots, Alert, Frames

	public static String captureScreenShot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String ScreenShotPath = System.getProperty("user.dir")+"//screenshots//a"+getCurrentDateTime()+ ".png";

		try {
			FileHandler.copy(src, new File(ScreenShotPath));
		} catch (Exception e) {
            System.out.println("Unable to capture ScrreShot"+e.getMessage());
		}

		return ScreenShotPath;
	}

	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
}
