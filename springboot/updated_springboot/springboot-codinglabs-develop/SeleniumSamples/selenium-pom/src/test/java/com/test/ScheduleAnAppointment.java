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
public class ScheduleAnAppointment {

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
		driver.findElement(By.linkText("Appointment Scheduling")).click();

	}

}
