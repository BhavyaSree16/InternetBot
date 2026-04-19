package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.CheckBoxPage;
import utils.ConfigReader;
import utils.TestListener;

@Listeners(TestListener.class)
public class CheckboxTest extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get(ConfigReader.get("baseUrl").replace("login", "checkboxes"));
        System.out.println("Navigated to Checkbox Page");
    }

    // ✅ Checkbox 1
    @Test(priority = 1)
    public void verifyCheckbox1() {

        CheckBoxPage page = new CheckBoxPage(driver);

        page.clickCheckbox1();
        System.out.println("Checkbox 1 clicked");

        Assert.assertTrue(page.isCheckbox1Selected());

        page.clickCheckbox1();
        System.out.println("Checkbox 1 unchecked");

        Assert.assertFalse(page.isCheckbox1Selected());

        System.out.println("Checkbox 1 verified successfully");
    }

    // ✅ Checkbox 2
    @Test(priority = 2)
    public void verifyCheckbox2() {

        CheckBoxPage page = new CheckBoxPage(driver);

        boolean initial = page.isCheckbox2Selected();
        System.out.println("Initial state: " + initial);

        page.clickCheckbox2();

        boolean after = page.isCheckbox2Selected();
        System.out.println("After toggle: " + after);

        Assert.assertNotEquals(initial, after);

        System.out.println("Checkbox 2 toggled successfully");
    }
}