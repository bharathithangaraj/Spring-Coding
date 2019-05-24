/**
 * 
 */
package com.selenium.test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author lavanya Jan 17, 2019
 */
public class Handling_iFrames {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "drivers" + File.separator + "ChromeDriver-mac");

		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");

		// Before
		// Tapping on menuBar
		// driver.findElement(By.className("navbar-toggle")).click();
		// driver.findElement(By.linkText("Practice")).click();

		// After
		// Now try with iFrame
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);

		// How to switch over the elements in iframes using Web Driver commands:
		// Basically, we can switch over the elements in frames using 3 ways.
		//
		// By Index
		// By Name or Id
		// By Web Element

		driver.switchTo().frame("courses-iframe");
		driver.findElement(By.className("navbar-toggle")).click(); // Menu

		driver.findElement(By.linkText("Practice")).click();

		Thread.sleep(2000);
		driver.quit();
		System.out.println("Executed and closed driver successfully");

	}

}
