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
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.util.FolderPaths;

/**
 * @author lavanya Jan 18, 2019
 */
public class DependencyTest {

	static WebDriver driver = null;

	@BeforeTest
	public void configDriver() {
		// Setting up driver path
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForMac);
		} else {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForWindows);
		}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Before Executing Test to configure Driver ");
	}

	@Test
	void flowers() {
		driver.get("http://www.floraindia.com");
		driver.findElement(By.xpath("//h3[contains(text(),'All Flowers')]")).click();

		List<WebElement> result = driver.findElements(By.className("product-image"));
		System.out.println("Total flowers   : "+result.size());
		Assert.assertEquals(result.size(), 24, "from flowers()::::Expecting total count of flowers 24 ");
	}

	@Test(dependsOnMethods = { "flowers" })
	public void blueFlowers() throws InterruptedException {
		driver.get("http://www.floraindia.com");
		driver.findElement(By.xpath("//h3[contains(text(),'All Flowers')]")).click();
		// Looking for Blue color flowers
		driver.findElement(By.id("color-60")).click();
		Thread.sleep(1000);
		
		List<WebElement> result = driver.findElements(By.className("product-image"));
		System.out.println("BlueFlowers Count  :  "+result.size());
		Assert.assertEquals(result.size(), 2, "from blueFlowers():::: Expecting total count of BlueFlowers 2 ");
	}

	@AfterTest
	public static void teardown() {
		System.out.println("Closing and quiting  Driver ");
		driver.close();
		driver.quit();

	}

}
