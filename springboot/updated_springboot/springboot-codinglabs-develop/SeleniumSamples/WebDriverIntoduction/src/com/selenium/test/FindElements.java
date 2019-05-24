/**
 * 
 */
package com.selenium.test;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author lavanya
 * Jan 16, 2019
 */
public class FindElements {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "drivers" + File.separator + "ChromeDriver-mac");

		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		
		//Finding list of elements and printing all
		List <WebElement> listOfLabels = driver.findElements(By.tagName("label"));
		System.out.println("Count of labels  ::: "+listOfLabels.size());
		for (WebElement webElement : listOfLabels) {
			System.out.println("Label Name :::  "+ webElement.getText());
		}
		
		List <WebElement> listOfOptions = driver.findElements(By.tagName("option"));
		System.out.println("Count of options  ::: ::: "+listOfOptions.size());
		for (WebElement webElement : listOfOptions) {
			System.out.println("Option Name :::  "+ webElement.getText());
		}
		
		driver.close();
		driver.quit();
		System.out.println("Executed and closed driver successfully");
		
	}

}
