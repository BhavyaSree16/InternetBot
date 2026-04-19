package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.AlertsPage;
import utils.ConfigReader;
import utils.TestListener;

@Listeners(TestListener.class)
public class AlertsTest extends BaseTest {

    @BeforeMethod
    public void navigateToAlertsPage() {
        driver.get(ConfigReader.get("baseUrl").replace("login", "javascript_alerts"));
        System.out.println("Navigated to Alerts Page");
    }

    // ✅ 1. JS ALERT
    @Test(priority = 1)
    public void verifyJSAlert() {

        AlertsPage page = new AlertsPage(driver);

        page.clickJSAlert();
        System.out.println("Clicked JS Alert");

        page.acceptAlert();
        System.out.println("Accepted Alert");

        String result = page.getResult();
        System.out.println("Result: " + result);

        Assert.assertEquals(result, "You successfully clicked an alert");

        System.out.println("JS Alert Verified Successfully");
    }

    // ❌ 2. JS CONFIRM (DISMISS)
    @Test(priority = 2)
    public void verifyJSConfirmDismiss() {

        AlertsPage page = new AlertsPage(driver);

        page.clickJSConfirm();
        System.out.println("Clicked JS Confirm");

        page.dismissAlert();
        System.out.println("Dismissed Alert");

        String result = page.getResult();
        System.out.println("Result: " + result);

        Assert.assertTrue(result.contains("Cancel"));

        System.out.println("JS Confirm Dismiss Verified");
    }

    // ✍️ 3. JS PROMPT
    @Test(priority = 3)
    public void verifyJSPrompt() {

        AlertsPage page = new AlertsPage(driver);

        page.clickJSPrompt();
        System.out.println("Clicked JS Prompt");

        page.enterTextInPrompt("Bhavya");
        System.out.println("Entered text in prompt");

        page.acceptAlert();

        String result = page.getResult();
        System.out.println("Result: " + result);

        Assert.assertTrue(result.contains("Bhavya"));

        System.out.println("JS Prompt Verified");
    }

    // 🔄 4. RESULT RESET CHECK
    @Test(priority = 4)
    public void verifyResultClears() {

        AlertsPage page = new AlertsPage(driver);

        // First action
        page.clickJSAlert();
        page.acceptAlert();
        String firstResult = page.getResult();

        // Second action
        page.clickJSConfirm();
        page.dismissAlert();
        String secondResult = page.getResult();

        System.out.println("First Result: " + firstResult);
        System.out.println("Second Result: " + secondResult);

        Assert.assertNotEquals(firstResult, secondResult);

        System.out.println("Result text updates correctly between actions");
    }
}