package com.selenium.test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author lavanya
 * Jan 16, 2019
 */
public class SelectRadio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "drivers" + File.separator + "ChromeDriver-mac");

		WebDriver driver = new ChromeDriver();

		driver.get("https://learn.letskodeit.com/p/practice");

		driver.findElement(By.id("bmwradio")).click();
		System.out.println("Selected BMW");
		driver.findElement(By.id("benzradio")).click();
		System.out.println("Selected Benz");
		driver.findElement(By.id("hondaradio")).click();
		System.out.println("Selected Honda");

		driver.quit();
		System.out.println("Executed and closed driver successfully");

	}

}
