package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CheckBoxPage extends BasePage {

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    private By checkbox1 = By.xpath("(//input[@type='checkbox'])[1]");
    private By checkbox2 = By.xpath("(//input[@type='checkbox'])[2]");

    public void clickCheckbox1() {
        click(checkbox1);
    }

    public void clickCheckbox2() {
        click(checkbox2);
    }

    public boolean isCheckbox1Selected() {
        return driver.findElement(checkbox1).isSelected();
    }

    public boolean isCheckbox2Selected() {
        return driver.findElement(checkbox2).isSelected();
    }
}