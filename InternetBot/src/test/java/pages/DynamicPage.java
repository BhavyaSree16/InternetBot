package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class DynamicPage extends BasePage {

    public DynamicPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By startBtn = By.xpath("//button[text()='Start']");
    private By loadingText = By.id("finish");
    private By disappearingElement = By.xpath("//a[text()='Gallery']"); // example element

    // Actions
    public void clickStart() {
        click(startBtn);
    }

    // Wait and get text
    public String getLoadedText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadingText));
        return driver.findElement(loadingText).getText();
    }

    // Check disappearing element
    public boolean isElementPresent() {
        try {
            return driver.findElement(disappearingElement).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}