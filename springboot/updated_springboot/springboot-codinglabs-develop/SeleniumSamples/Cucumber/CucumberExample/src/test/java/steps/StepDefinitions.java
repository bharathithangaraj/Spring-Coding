package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {

    public static WebDriver driver;

    @Given("^User is on the students login page$")
    public void user_is_on_the_students_login_page() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
    }

    @When("^User logs in with user name \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_logs_in_with_user_name_and_password(String arg1, String arg2) throws Throwable {
        driver.findElement(By.name("uname")).sendKeys(arg1);
        driver.findElement(By.name("pwd")).sendKeys(arg2);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("^Initial user count should be \"([^\"]*)\"$")
    public void initial_user_count_should_be(String arg1) throws Throwable {
        int studentsCount = driver.findElements(By.tagName("tr")).size() - 1;

        Assert.assertEquals(Long.parseLong(arg1), studentsCount);
    }

    @Then("^The user should get error message$")
    public void the_user_should_get_error_message() throws Throwable {
        Assert.assertTrue(driver.getPageSource().contains("Invalid Login. Please Login."));
    }
}
