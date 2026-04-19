package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.DynamicPage;
import utils.ConfigReader;
import utils.TestListener;

@Listeners(TestListener.class)
public class DynamicTest extends BaseTest {

    // ✅ 1. Click Start and wait for element
    @Test(priority = 1)
    public void verifyDynamicLoading() {

        driver.get(ConfigReader.get("baseUrl").replace("login", "dynamic_loading/1"));
        System.out.println("Navigated to Dynamic Loading Page");

        DynamicPage page = new DynamicPage(driver);

        page.clickStart();
        System.out.println("Clicked Start button");

        String text = page.getLoadedText();
        System.out.println("Loaded Text: " + text);

        Assert.assertEquals(text, "Hello World!");

        System.out.println("Dynamic Loading Verified Successfully");
    }

    // ✅ 2. Verify loaded text again (separate validation)
    @Test(priority = 2)
    public void verifyLoadedText() {

        driver.get(ConfigReader.get("baseUrl").replace("login", "dynamic_loading/2"));

        DynamicPage page = new DynamicPage(driver);

        page.clickStart();

        String text = page.getLoadedText();
        System.out.println("Loaded Text: " + text);

        Assert.assertTrue(text.contains("Hello World!"));

        System.out.println("Loaded text validated");
    }

    // 🔄 3. Disappearing element reappears after refresh
    @Test(priority = 3)
    public void verifyDisappearingElement() {

        driver.get(ConfigReader.get("baseUrl").replace("login", "disappearing_elements"));

        DynamicPage page = new DynamicPage(driver);

        boolean before = page.isElementPresent();
        System.out.println("Element present before refresh: " + before);

        driver.navigate().refresh();

        boolean after = page.isElementPresent();
        System.out.println("Element present after refresh: " + after);

        // At least one should be true → element reappears
        Assert.assertTrue(before || after);

        System.out.println("Disappearing element behavior verified");
    }
}