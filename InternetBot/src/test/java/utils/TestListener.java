package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.*;

import base.BaseTest;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getReport();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = extent.createTest(result.getName());
        test.set(extentTest);

        test.get().info("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed Successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        Object obj = result.getInstance();
        WebDriver driver = ((BaseTest) obj).driver;

        String path = ScreenshotUtil.capture(driver, result.getName());

        if (path != null) {
            try {
                test.get().addScreenCaptureFromPath(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
}