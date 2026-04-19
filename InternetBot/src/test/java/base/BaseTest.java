package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initDriver(ConfigReader.get("browser"));
        driver.get(ConfigReader.get("baseUrl"));
        System.out.println("Browser Launched");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        System.out.println("Browser Closed");
    }
}