package com.selenium.test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author lavanya Jan 16, 2019
 */
public class SelectFromDropDown {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "drivers" + File.separator + "ChromeDriver-mac");

		WebDriver driver = new ChromeDriver();

		// Open browser with given url
		driver.get("https://learn.letskodeit.com/p/practice");

		// WebElement mySelectElement = driver.findElement(By.id("mySelect"));
		// Select dropdown= new Select(mySelectElement);

		WebElement list = driver.findElement(By.id("carselect"));
		Select dropdown = new Select(list);

		dropdown.selectByVisibleText("Benz");
		// dropdown.selectByIndex(2);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("carselect")).isSelected();
		driver.quit();
		System.out.println("Executed and closed driver successfully");

	}
}
