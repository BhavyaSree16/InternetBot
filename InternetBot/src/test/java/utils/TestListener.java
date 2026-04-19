package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

import base.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Test Failed: " + result.getName());

        Object obj = result.getInstance();
        WebDriver driver = ((BaseTest) obj).driver;

        ScreenshotUtil.capture(driver, result.getName());
    }
}