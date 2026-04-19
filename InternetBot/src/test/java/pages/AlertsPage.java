package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    private By jsAlertBtn = By.xpath("//button[text()='Click for JS Alert']");
    private By jsConfirmBtn = By.xpath("//button[text()='Click for JS Confirm']");
    private By jsPromptBtn = By.xpath("//button[text()='Click for JS Prompt']");
    private By resultText = By.id("result");

    // Actions
    public void clickJSAlert() {
        click(jsAlertBtn);
    }

    public void clickJSConfirm() {
        click(jsConfirmBtn);
    }

    public void clickJSPrompt() {
        click(jsPromptBtn);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void enterTextInPrompt(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    // Getter
    public String getResult() {
        return getText(resultText);
    }
}