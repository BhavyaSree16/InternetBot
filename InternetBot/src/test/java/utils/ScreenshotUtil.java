package utils;

import org.openqa.selenium.*;
import java.io.File;
import org.apache.commons.io.FileUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String name) {

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String path = "reports/screenshots/" + name + "_" +
                    new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png";

            FileUtils.copyFile(src, new File(path));

            return path;

        } catch (Exception e) {
            return null;
        }
    }
}