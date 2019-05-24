import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestDocker {
    public static void main(String args[]) throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.get("http://google.com");

        System.out.println(driver.getTitle());
    }
}
