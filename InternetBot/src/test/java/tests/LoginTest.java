package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;
import utils.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    // ✅ 1. VALID LOGIN
    @Test(priority = 1)
    public void verifyValidLogin() {

        LoginPage page = new LoginPage(driver);

        page.login(
                ConfigReader.get("validUsername"),
                ConfigReader.get("validPassword")
        );

        System.out.println("Valid Login Attempted");

        Assert.assertTrue(page.getMessage().contains("secure area"));
        Assert.assertTrue(page.isLogoutDisplayed());

        System.out.println("Valid Login Verified Successfully");
    }

    // ❌ 2. INVALID LOGIN (SCREENSHOT WILL TRIGGER HERE)
    @Test(priority = 2)
    public void verifyInvalidLogin() {

        LoginPage page = new LoginPage(driver);

        page.login(
                ConfigReader.get("invalidUsername"),
                ConfigReader.get("invalidPassword")
        );

        System.out.println("Invalid Login Attempted");

        String msg = page.getMessage();

        // Force failure if invalid detected (to trigger screenshot)
        if (msg.contains("invalid")) {
            System.out.println("Invalid login detected → triggering failure for screenshot");
            Assert.fail("Invalid login → screenshot captured");
        }

        Assert.assertTrue(msg.contains("invalid"));
    }

    // ✅ 3. VERIFY SUCCESS MESSAGE
    @Test(priority = 3)
    public void verifySuccessMessage() {

        LoginPage page = new LoginPage(driver);

        page.login(
                ConfigReader.get("validUsername"),
                ConfigReader.get("validPassword")
        );

        String msg = page.getMessage();

        System.out.println("Success Message: " + msg);

        Assert.assertTrue(msg.contains("You logged into a secure area!"));

        System.out.println("Success Message Verified");
    }

    // 🚪 4. LOGOUT TEST
    @Test(priority = 4)
    public void verifyLogout() {

        LoginPage page = new LoginPage(driver);

        page.login(
                ConfigReader.get("validUsername"),
                ConfigReader.get("validPassword")
        );

        page.clickLogout();

        System.out.println("Logout Clicked");

        Assert.assertTrue(page.isLoginPageDisplayed());

        System.out.println("Logout Verified → Redirected to Login Page");
    }
}