/**
 * 
 */
package com.selenium.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author lavanya Jan 17, 2019
 */
public class HandlingAlerts {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "drivers" + File.separator + "ChromeDriver-mac");

		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.name("enter-name")).sendKeys("WaveLabs");
		driver.findElement(By.id("alertbtn")).click();

		Thread.sleep(2000);
		Alert myAlert = driver.switchTo().alert();
		// Accept the Alert
		myAlert.accept();

		driver.quit();
		System.out.println("Executed and closed driver successfully");

	}

}
