/**
 * 
 */
package com.selenium.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author lavanya Jan 16, 2019
 */
public class SwitchWindow {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "drivers" + File.separator + "ChromeDriver-mac");

		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");

		String parentWindow = driver.getWindowHandle();

		driver.findElement(By.id("openwindow")).click();
		Thread.sleep(1000);
		captureScreenshots(driver, "NewWindowScreen");

		Set<String> allWindows = driver.getWindowHandles();
		for (String curWindow : allWindows) {
			driver.switchTo().window(curWindow);
			System.out.println("Navigated to :::: " + curWindow);
			captureScreenshots(driver, "Window Handle");
		}

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for (WebElement webElement : allLinks) {
			System.out.println(webElement.getText());
		}
		captureScreenshots(driver, "To Capture all links of screen");

		List<WebElement> withClassName = driver.findElements(By.className("btn-group"));
		withClassName.get(0).click();
		// Selecting Software Testing
		driver.findElement(By.xpath("//a[contains(text(), 'Software Testing (5)')]")).click();

		Thread.sleep(2000);
		captureScreenshots(driver, "Selected from dropDown");

		driver.switchTo().window(parentWindow);
		System.out.println("Navigated back to Parent window");
		captureScreenshots(driver, "Navigated to Parent Window");

		driver.quit();
		System.out.println("Executed and closed driver successfully");

	}

	private static void captureScreenshots(WebDriver driverInstance, String screenName ) {
		File screenshotFile = ((TakesScreenshot) driverInstance).getScreenshotAs(OutputType.FILE);
		try {
			
			StringBuilder fileLocation = new StringBuilder();
			fileLocation.append(System.getProperty("user.dir") + "//src//screenshots//" + screenName + ".jpeg");
			File destFile = new File(fileLocation.toString());
			FileUtils.copyFile(screenshotFile, destFile, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	private static String getUniquenumber() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyss");
		String time = sdf.format(cal.getTime()) + System.currentTimeMillis();
		return time;
	}

}
