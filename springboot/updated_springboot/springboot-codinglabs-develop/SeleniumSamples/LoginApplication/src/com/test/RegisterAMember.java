package com.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author lavanya
 * Jan 16, 2019
 */

public class RegisterAMember {

	public final static short TYPE_UPPER_ONLY = 1;
	public final static short TYPE_LOWER_ONLY = 2;
	public final static Random rnd = new Random();

	static final char[] alphas = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

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
		
		captureScreenshots(driver);

		// Tap on Registration Link
		driver.findElement(By.linkText("Register a patient")).click();

		String memberName = "pa"+generateRandomString();
		// Register
		driver.findElement(By.name("givenName")).sendKeys(memberName);
		driver.findElement(By.name("familyName")).sendKeys("a");

		captureScreenshots(driver);

		// Gender Label
		driver.findElement(By.id("genderLabel")).click();

		
		// select gender from dropdown/select
		Select gender = new Select(driver.findElement(By.id("gender-field")));
		gender.selectByVisibleText("Male");

		captureScreenshots(driver);

		// DOB Label
		driver.findElement(By.id("birthdateLabel")).click();

		// Day
		driver.findElement(By.name("birthdateDay")).sendKeys("10");
		// Month
		Select months = new Select(driver.findElement(By.id("birthdateMonth-field")));
		months.selectByIndex(4); // April
		// Year
		driver.findElement(By.id("birthdateYear-field")).sendKeys("1995");

		captureScreenshots(driver);

		// Address Tab
		driver.findElement(By.xpath("//span[contains(text(), 'Address')]")).click();

		driver.findElement(By.id("address1")).sendKeys("Manikonda");
		driver.findElement(By.id("address2")).sendKeys("Hyderabad");
		// City
		driver.findElement(By.id("cityVillage")).sendKeys("Hyderabad");
		// State
		driver.findElement(By.id("stateProvince")).sendKeys("Telangana");
		// Country
		driver.findElement(By.id("country")).sendKeys("India");
		// ZIP
		driver.findElement(By.id("postalCode")).sendKeys("500009");

		driver.findElement(By.xpath("//span[contains(text(), 'Phone Number')]")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("9898989898");

		// Relationships Tab
		driver.findElement(By.xpath("//span[contains(text(), 'Relatives')]")).click();

		Select relations = new Select(driver.findElement(By.id("relationship_type")));
		relations.selectByVisibleText("Parent");

		// Confirmation
		driver.findElement(By.xpath("//span[contains(text(), 'Confirm')]")).click();
		// Confirm with Submit
		driver.findElement(By.id("submit")).click();

		captureScreenshots(driver);
		// LogOut
		driver.findElement(By.linkText("Logout")).click();

		// Quit the driver/browser
		driver.quit();
		System.out.println("Executed successfully and closed driver");

	}

	public static void captureScreenshots(WebDriver driverInstance) {
		File screenshotFile = ((TakesScreenshot) driverInstance).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File(
					System.getProperty("user.dir")+"//src//screenshots//" + getUniquenumber() + ".png"),
					true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	public static String getUniquenumber() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyss");
		String time = sdf.format(cal.getTime()) + System.currentTimeMillis();
		return time;
	}

	/**
	 * Method to generate random string
	 * @return 
	 */
	public static String generateRandomString() {

		short type = 2;
		int min = type == TYPE_LOWER_ONLY ? 26 : 0;
		int max = type == TYPE_UPPER_ONLY ? 26 : alphas.length;
		String generated = "";
		for (int i = 0; i < 5; i++) {
			int random = rnd.nextInt(max - min) + min;
			generated += alphas[random];
		}
		return generated;
	}

}
