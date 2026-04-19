package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.DropdownPage;
import utils.ConfigReader;
import utils.TestListener;

@Listeners(TestListener.class)
public class DropdownTest extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get(ConfigReader.get("baseUrl").replace("login", "dropdown"));
        System.out.println("Navigated to Dropdown Page");
    }

    // ✅ Select each option
    @Test(priority = 1)
    public void verifyDropdownSelection() {

        DropdownPage page = new DropdownPage(driver);

        page.selectOption("Option 1");
        System.out.println("Selected Option 1");

        Assert.assertEquals(page.getSelectedOption(), "Option 1");

        page.selectOption("Option 2");
        System.out.println("Selected Option 2");

        Assert.assertEquals(page.getSelectedOption(), "Option 2");

        System.out.println("Dropdown selection verified");
    }

    // ✅ Verify option count
    @Test(priority = 2)
    public void verifyDropdownOptionsCount() {

        DropdownPage page = new DropdownPage(driver);

        int count = page.getOptionsCount();
        System.out.println("Dropdown options count: " + count);

        Assert.assertEquals(count, 3); // includes default option

        System.out.println("Dropdown options count verified");
    }
}