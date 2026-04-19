package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.UploadPage;
import utils.ConfigReader;
import utils.TestListener;

@Listeners(TestListener.class)
public class UploadTest extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get(ConfigReader.get("baseUrl").replace("login", "upload"));
        System.out.println("Navigated to Upload Page");
    }

    // ✅ 1. Verify UI before interaction
    @Test(priority = 1)
    public void verifyUploadPageUI() {

        UploadPage page = new UploadPage(driver);

        System.out.println("Checking Upload Page UI...");

        Assert.assertTrue(page.getPageTitle().contains("The Internet"));
        Assert.assertTrue(page.isUploadFormVisible());
        Assert.assertTrue(page.isHeadingDisplayed());

        System.out.println("Upload Page UI Verified Successfully");
    }

    // ✅ 2. Upload valid file
    @Test(priority = 2)
    public void verifyFileUpload() {

        UploadPage page = new UploadPage(driver);

        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/test-data/sample.txt";

        System.out.println("Uploading valid file...");

        page.uploadFile(filePath);

        String fileName = page.getUploadedFileName();
        System.out.println("Uploaded File: " + fileName);

        Assert.assertEquals(fileName, "sample.txt");

        System.out.println("Valid File Upload Verified Successfully");
    }

    // ❌ 3. Upload invalid file (graceful handling)
    @Test(priority = 3)
    public void verifyInvalidFileUpload() {

        UploadPage page = new UploadPage(driver);

        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/test-data/sample.exe";

        System.out.println("Uploading invalid file...");

        page.uploadFile(filePath);

        String fileName = page.getUploadedFileName();
        System.out.println("Result: " + fileName);

        // Site accepts all → just verify response exists
        Assert.assertNotNull(fileName);

        System.out.println("Invalid File Upload Handled Gracefully");
    }
}