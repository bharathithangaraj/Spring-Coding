/**
 * 
 */
package com.selenium.test;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author lavanya
 * Jan 17, 2019
 */
public class HandlingANewTab {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "drivers" + File.separator + "ChromeDriver-mac");

		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		
		// opens a new tab
		driver.findElement(By.id("opentab")).click();
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0)); //Switching to main Tab
	    
	    driver.switchTo().window(tabs2.get(1));  //Switching to child Tab
	    driver.close(); // Closing child tab
	    driver.switchTo().window(tabs2.get(0));  // Switching to main/parent tab
	    
	    driver.quit();
	    System.out.println("Executed and closed driver successfully");


	}

}
