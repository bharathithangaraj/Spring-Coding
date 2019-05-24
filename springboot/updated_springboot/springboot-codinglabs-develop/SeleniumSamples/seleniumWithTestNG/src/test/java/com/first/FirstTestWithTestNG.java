/**
 * 
 */
package com.first;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.util.FolderPaths;

/**
 * @author lavanya Jan 18, 2019
 */
public class FirstTestWithTestNG {
	
	// Logger implementation
	private final static Logger logger = Logger.getLogger(FirstTestWithTestNG.class);

	static WebDriver driver = null;

	@BeforeClass
	public void configDriver() {
		// Setting up driver path
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForMac);
		} else {
			System.setProperty("webdriver.chrome.driver", FolderPaths.chromeDriverPathForWindows);
		}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		logger.info("Before Executing Test to configure Driver ");
	}

	@Test
	public void birthDay() {
		driver.get("http://www.floraindia.com");
		driver.findElement(By.xpath("//h3[contains(text(),'Birthday')]")).click();

		List<WebElement> result = driver.findElements(By.className("product-image"));
		logger.info(result.size());
		Assert.assertEquals(result.size(), 24, "from birthDay()::::Expecting total count of Birthday cakes as 24 ");
	}

	@Test
	void flowers() {
		driver.get("http://www.floraindia.com");
		driver.findElement(By.xpath("//h3[contains(text(),'All Flowers')]")).click();

		List<WebElement> result = driver.findElements(By.className("product-image"));
		logger.info(result.size());
		Assert.assertEquals(result.size(), 24, "from flowers()::::Expecting total count of flowers 24 ");
	}

	@Test
	void chocolates() throws InterruptedException {
		driver.get("http://www.floraindia.com");
		driver.findElement(By.xpath("//h3[contains(text(),'Chocolates')]")).click();

		// Looking for chocolatesBars
		driver.findElement(By.id("product_type-135")).click();
		Thread.sleep(1000);
		List<WebElement> result = driver.findElements(By.className("product-image"));
		logger.info(result.size());
		Assert.assertEquals(result.size(), 5, "from chocolates():::: Expecting total count of ChocolateBars 5 ");
	}

	@Test
	void combos() throws InterruptedException {

		driver.get("http://www.floraindia.com");
		driver.findElement(By.xpath("//h3[contains(text(),'Combos')]")).click();

		// Looking for Basket
		driver.findElement(By.id("product_type-114")).click();
		Thread.sleep(1000);
		List<WebElement> result = driver.findElements(By.className("product-image"));
		logger.info(result.size());
		Assert.assertEquals(result.size(), 18, "from combos():::: Expecting total count of Baskets 18 ");

	}

	@AfterClass
	public static void teardown() {
		logger.info("Closing and quiting  Driver ");
		driver.close();
		driver.quit();

	}

}
