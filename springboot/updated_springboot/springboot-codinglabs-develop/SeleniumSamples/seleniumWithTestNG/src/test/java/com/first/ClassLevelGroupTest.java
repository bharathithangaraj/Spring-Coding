/**
 * 
 */
package com.first;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.util.FolderPaths;

/**
 * @author lavanya Jan 18, 2019
 */
public class ClassLevelGroupTest {

	static WebDriver driver = null;

	@BeforeClass
	public void configDriver() {
		// Setting up driver path

		System.out.println("Before Executing Test to configure Driver ");
	}

	@Test(groups = { "MethodLevelGroup" })
	public void birthDay() {

		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForMac);
		} else {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForWindows);
		}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("http://www.floraindia.com");
		driver.findElement(By.xpath("//h3[contains(text(),'Birthday')]")).click();

		List<WebElement> result = driver.findElements(By.className("product-image"));
		System.out.println("from birthDay  :" + result.size());
	}

	@Test(groups = { "MethodLevelGroup" })
	void flowers() {

		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForMac);
		} else {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForWindows);
		}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("http://www.floraindia.com");
		driver.findElement(By.xpath("//h3[contains(text(),'All Flowers')]")).click();

		List<WebElement> result = driver.findElements(By.className("product-image"));
		System.out.println("from flowers ()  :" + result.size());
	}

	@Test
	void chocolates() throws InterruptedException {

		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForMac);
		} else {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForWindows);
		}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("http://www.floraindia.com");
		driver.findElement(By.xpath("//h3[contains(text(),'Chocolates')]")).click();

		// Looking for chocolatesBars
		driver.findElement(By.id("product_type-135")).click();
		Thread.sleep(1000);
		List<WebElement> result = driver.findElements(By.className("product-image"));
		System.out.println("from chocolates() " + result.size());
	}

	@Test
	void combos() throws InterruptedException {

		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForMac);
		} else {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForWindows);
		}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("http://www.floraindia.com");
		driver.findElement(By.xpath("//h3[contains(text(),'Combos')]")).click();

		// Looking for Basket
		driver.findElement(By.id("product_type-114")).click();
		Thread.sleep(1000);
		List<WebElement> result = driver.findElements(By.className("product-image"));
		System.out.println("from combos():  " + result.size());

	}

	@AfterClass
	public static void teardown() {
		System.out.println("Closing and quiting  Driver ");
		driver.close();
		driver.quit();

	}

}
