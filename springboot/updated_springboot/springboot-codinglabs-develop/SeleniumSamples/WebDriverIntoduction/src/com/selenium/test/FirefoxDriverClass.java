package com.selenium.test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverClass {

	public static void main(String[] args) {

		// System.setProperty("webdriver.gecko.driver",
		// System.getProperty("user.dir") + File.separator + "src"
		// + File.separator + "drivers" + File.separator + "GeckoDriver-mac");

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "drivers" + File.separator + "ChromeDriver-mac");

		// create firefox driver
		// WebDriver ffDriver = new FirefoxDriver();

		// Chrome Driver
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com");

		// ffDriver.findElement(By.className("")).sendKeys("123sss");

		driver.quit();

	}

}
