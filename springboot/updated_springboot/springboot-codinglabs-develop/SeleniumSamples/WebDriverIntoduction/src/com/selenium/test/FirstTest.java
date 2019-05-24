package com.selenium.test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author lavanya
 * Jan 16, 2019
 */

public class FirstTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "drivers" + File.separator + "ChromeDriver-mac");

		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		driver.findElement(By.name("q")).sendKeys("Seleniumhq" + Keys.ENTER);
		
//		driver.quit();
//		System.out.println("Executed and closed driver successfully");

	}

}
