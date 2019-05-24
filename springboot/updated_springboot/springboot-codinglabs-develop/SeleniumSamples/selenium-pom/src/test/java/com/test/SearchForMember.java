package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.po.LoginPO;
import com.util.CommonUtil;
import com.util.FolderPaths;

/**
 * 
 * @author lavanya
 * Jan 11, 2019
 */
public class SearchForMember {

	public static void main(String[] args) {
		// Setting up driver path
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForMac);
		} else {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForWindows);
		}

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.openmrs.org/openmrs/");

		// Creating instance of PO class
		LoginPO loginPO = new LoginPO(driver);
		loginPO.loginDetails(CommonUtil.getPopertyFromConfig("username"), CommonUtil.getPopertyFromConfig("password"));

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
