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
public class IsElementDisplayed {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "drivers" + File.separator + "ChromeDriver-mac");

		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		
		if(driver.findElement(By.id("displayed-text")).isDisplayed()){
			System.out.println("Element is visible");
		} else {
			System.out.println("Element is invisible");
		}
		Thread.sleep(2000);
		driver.findElement(By.id("hide-textbox")).click();  // Tapping to hide
		if(driver.findElement(By.id("displayed-text")).isDisplayed()){
			System.out.println("Element is visible");
		} else {
			System.out.println("Element is invisible");
		}
		Thread.sleep(2000);
		driver.findElement(By.id("show-textbox")).click();  // Tapping to show
		if(driver.findElement(By.id("displayed-text")).isDisplayed()){
			System.out.println("Element is visible");
		} else {
			System.out.println("Element is invisible");
		}
		Thread.sleep(2000);
		driver.quit();
	    System.out.println("Executed and closed driver successfully");

	}

}
