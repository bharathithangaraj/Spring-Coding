package simpleTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleTest {
    public static void main(String args[]) {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        driver.findElement(By.name("uname")).sendKeys("admin");
        driver.findElement(By.name("pwd")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        int studentsCount = driver.findElements(By.tagName("tr")).size() - 1;

        System.out.println(studentsCount);
    }
}
