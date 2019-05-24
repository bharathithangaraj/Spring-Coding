package com.test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchForMember {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "drivers" + File.separator + "ChromeDriver-mac");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.openmrs.org/openmrs/");

		// Login
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");

		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();

		// Tap on search option
		driver.findElement(By.linkText("Find Patient Record")).click();

		// searchFiled
		driver.findElement(By.id("patient-search")).sendKeys("rama");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String resultCountMessage = driver.findElement(By.id("patient-search-results-table_info")).getText();

		System.out.println(resultCountMessage);
		String expectedMessage = "Showing 1 to 1 of 1 entries";
		if (resultCountMessage.contentEquals(expectedMessage)) {
			System.out.println("Record found successfully  ");
		} else {
			System.out.println("No Records with the given name ");
		}

		// LogOut
		driver.findElement(By.linkText("Logout")).click();

		// Quit the driver/browser
		driver.quit();
	}

}
