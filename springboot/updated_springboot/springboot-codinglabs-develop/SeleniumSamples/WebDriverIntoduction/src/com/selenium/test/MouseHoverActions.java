/**
 * 
 */
package com.selenium.test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * @author lavanya Jan 17, 2019
 */
public class MouseHoverActions {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "drivers" + File.separator + "ChromeDriver-mac");

		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		
		WebElement element = driver.findElement(By.id("mousehover"));
		
		Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(element)
                .build();
        
        mouseOverHome.perform();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Top")).click();

		driver.quit();
		System.out.println("Executed and closed driver successfully");

	}

}
