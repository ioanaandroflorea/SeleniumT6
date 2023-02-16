package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static void takeScreenshot(ChromeDriver driver, String filename){
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + String.format("/Logs/%s.png", filename);
        try {
            org.apache.commons.io.FileUtils.copyFile(source, new File(destinationFile));
        } catch (IOException e) {
            System.out.println("Nu am reusit sa fac screenshot.");
            e.printStackTrace();
        }
    }
}
