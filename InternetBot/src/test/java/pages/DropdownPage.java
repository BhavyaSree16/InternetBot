package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

import java.util.List;

public class DropdownPage extends BasePage {

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    private By dropdown = By.id("dropdown");

    public void selectOption(String value) {
        Select select = new Select(driver.findElement(dropdown));
        select.selectByVisibleText(value);
    }

    public String getSelectedOption() {
        Select select = new Select(driver.findElement(dropdown));
        return select.getFirstSelectedOption().getText();
    }

    public int getOptionsCount() {
        Select select = new Select(driver.findElement(dropdown));
        List<WebElement> options = select.getOptions();
        return options.size();
    }
}