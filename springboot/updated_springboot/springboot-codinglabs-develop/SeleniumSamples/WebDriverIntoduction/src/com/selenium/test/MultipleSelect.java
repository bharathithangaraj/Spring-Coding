package com.selenium.test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author lavanya Jan 16, 2019
 */
public class MultipleSelect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "drivers" + File.separator + "ChromeDriver-mac");

		WebDriver driver = new ChromeDriver();

		driver.get("https://learn.letskodeit.com/p/practice");

		Select oSelect = new Select(driver.findElement(By.id("multiple-select-example")));
		oSelect.selectByIndex(1);
		oSelect.selectByIndex(2);

		// Or can be used as
		// oSelect.selectByVisibleText("Apple");
		// oSelect.selectByVisibleText("Peach");

		// Or can be used as
		// oSelect.selectByValue("apple");
		// oSelect.selectByValue("orange");

		driver.quit();
		System.out.println("Executed and closed driver successfully");

	}
}
