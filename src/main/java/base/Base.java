
package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import baseUtils.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties properties;
	protected static Logger log = LogManager.getLogger(Base.class);
	// public static EventFiringWebDriver edriver;

	@BeforeMethod
	@SuppressWarnings("deprecation")
	public void init() throws IOException {
		properties = new Properties();
		FileInputStream fp = new FileInputStream(Utilities.PATH);
		properties.load(fp);
		String browserName = properties.getProperty(Utilities.BROWSERNAME);
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		/*
		 * edriver = new EventFiringWebDriver(driver); EventHandler handler = new
		 * EventHandler(); edriver.register(handler);
		 */

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Utilities.IMPlICITWAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Utilities.PAGELOADTIME, TimeUnit.SECONDS);
		driver.get(properties.getProperty(Utilities.URL));
	}

	@AfterMethod
	public void tearDown() throws IOException {
		log.info("In tear down block");
		driver.quit();
		log.info("Script execution ends....");
	}

	/**
	 * @param result
	 * @throws IOException
	 */
	public void getScreenshot(String result) throws IOException {
		log.info("Capturing screenshot");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("/Users/Dell/eclipse-workspace/demoAutomation/Screenshots/" + result + "screenshot.png"));
	}
}
