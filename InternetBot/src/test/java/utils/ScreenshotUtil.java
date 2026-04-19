package utils;

import org.openqa.selenium.*;
import java.io.File;
import org.apache.commons.io.FileUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void capture(WebDriver driver, String name) {

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String path = "reports/screenshots/" + name + "_" +
                    new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png";

            FileUtils.copyFile(src, new File(path));

            System.out.println("Screenshot saved: " + path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}