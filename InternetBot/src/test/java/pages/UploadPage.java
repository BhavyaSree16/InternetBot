package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class UploadPage extends BasePage {

    public UploadPage(WebDriver driver) {
        super(driver);
    }

    private By fileInput = By.id("file-upload");
    private By uploadBtn = By.id("file-submit");
    private By uploadedFile = By.id("uploaded-files");
    private By heading = By.xpath("//h3[contains(text(),'File Uploader')]");

    // Action
    public void uploadFile(String filePath) {
        driver.findElement(fileInput).sendKeys(filePath);
        click(uploadBtn);
    }

    // Get uploaded file name
    public String getUploadedFileName() {
        return getText(uploadedFile);
    }

    // UI Checks
    public boolean isUploadFormVisible() {
        return driver.findElement(fileInput).isDisplayed();
    }

    public boolean isHeadingDisplayed() {
        return driver.findElement(heading).isDisplayed();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}