package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");
    private By message = By.id("flash");
    private By logoutBtn = By.linkText("Logout");
    private By loginHeading = By.xpath("//h2[contains(text(),'Login Page')]");

    public void login(String user, String pass) {
        type(username, user);
        type(password, pass);
        click(loginBtn);
    }

    public String getMessage() {
        return getText(message);
    }

    public boolean isLogoutDisplayed() {
        return driver.findElement(logoutBtn).isDisplayed();
    }

    public void clickLogout() {
        click(logoutBtn);
    }

    public boolean isLoginPageDisplayed() {
        return driver.findElement(loginHeading).isDisplayed();
    }
}