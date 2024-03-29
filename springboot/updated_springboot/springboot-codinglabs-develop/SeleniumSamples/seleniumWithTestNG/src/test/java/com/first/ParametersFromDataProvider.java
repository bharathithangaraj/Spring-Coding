/**
 * 
 */
package com.first;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.FolderPaths;

/**
 * @author lavanya Jan 18, 2019
 */
public class ParametersFromDataProvider {

	static WebDriver driver = null;

	@BeforeClass
	public void configDriver() {
		// Setting up driver path
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForMac);
		} else {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForWindows);
		}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Before Executing Test to configure Driver ");
	}

	// Here we are calling the Data Provider object with its Name
	@Test(dataProvider = "LoginCredens")
	public void test(String sUsername, String sPassword) {

		driver.get("http://www.floraindia.com");
		driver.findElement(By.linkText("Log In / Register")).click();
		driver.findElement(By.id("login:email")).sendKeys(sUsername);
		driver.findElement(By.id("login:password")).sendKeys(sPassword);
		driver.findElement(By.id("srLoginSubmit")).click();

	}

	@DataProvider(name = "LoginCredens")
	public static Object[][] credentials() {
		return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" } };
	}

	@AfterClass
	public static void teardown() {
		System.out.println("Closing and quiting  Driver ");
		driver.close();
		driver.quit();

	}

}
