package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.po.LoginPO;
import com.po.RegistrationPO;
import com.util.CommonUtil;
import com.util.FolderPaths;

/**
 * 
 * @author lavanya
 * Jan 11, 2019
 */
public class RegisterAMember {

	public static void main(String[] args) {

		// Setting up driver path
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForMac);
		} else {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForWindows);
		}

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.openmrs.org/openmrs/");

		// Creating instance of Login PO class
		LoginPO loginPO = new LoginPO(driver);
		loginPO.loginDetails(CommonUtil.getPopertyFromConfig("username"), CommonUtil.getPopertyFromConfig("password"));
		CommonUtil.captureScreenshots(driver);
		System.out.println("Login Successful");

		// Creating instance of Registration PO class
		RegistrationPO registrationPO = new RegistrationPO(driver);

		// Tap on Registration Link
		registrationPO.tapToRegister();

		// Generate patient firstName and lastName with some random string
		String memberFName = "FName" + CommonUtil.generateRandomString();
		String memberLName = CommonUtil.generateRandomString();
		// Register
		registrationPO.patientName(memberFName, memberLName);
		CommonUtil.captureScreenshots(driver);

		// Gender Label - select gender from dropdown/select
		registrationPO.genderSelectionFromDropDown("Male");
		CommonUtil.captureScreenshots(driver);

		// DOB Label - Date,Month and Year
		registrationPO.dateOfBirth("10", "January", "1995");
		CommonUtil.captureScreenshots(driver);
		// Address Tab and details
		registrationPO.addressDetails();
		CommonUtil.captureScreenshots(driver);

		// Phone Number
		registrationPO.phoneNumber();
		CommonUtil.captureScreenshots(driver);

		// Relationships Tab
		registrationPO.relationShipTypeByDropDown("Parent");
		CommonUtil.captureScreenshots(driver);

		// Confirmation
		registrationPO.confirmButton();
		CommonUtil.captureScreenshots(driver);

		// Confirm with Submit
		registrationPO.submitButton();
		CommonUtil.captureScreenshots(driver);
		System.out.println("Registration Successful");

		// LogOut
		registrationPO.logOutBtn();
		System.out.println("Logged out Successfully");

		// Quit the driver/browser
		driver.quit();
		System.out.println("Closed Driver");

	}

}
