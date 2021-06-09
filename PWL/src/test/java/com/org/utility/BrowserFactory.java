package com.org.utility;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) 
	
    {
		if (browserName.equalsIgnoreCase("Chrome")) 
		{
			ChromeOptions options = new ChromeOptions();
			HashMap<String, Integer> contentSetting = new HashMap<String, Integer>();
			HashMap<String, Object> profile = new HashMap<String, Object>();
			HashMap<String, Object> prefs = new HashMap<String, Object>();
			contentSetting.put("notifications", 1);
			contentSetting.put("geolocation", 1);
			profile.put("managed_default_content_settings", contentSetting);
			prefs.put("profile", profile);
			options.setExperimentalOption("prefs", prefs);
			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(appURL);
		}
		
		
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) 
	{
		driver.close();
	}

}
