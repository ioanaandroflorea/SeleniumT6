package Tema6;

import org.driver.BrowserManager;
import utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class DemoQA {
    static ChromeDriver driver = null;

    public static void main(String[] args) {
        navigateToDemoQAWindowPage();
        clickNewTabButton();
        clickNewWindow();

        try {
            clickNewWindowMessage();
        } catch (NoSuchElementException e) {
            FileUtils.takeScreenshot(driver, "window message");
        } finally {
            BrowserManager.closeBrowser(driver);
        }
    }

    public static void navigateToDemoQAWindowPage() {
        driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        System.out.println("Demo QA window page opened.");
    }

    public static void clickNewTabButton() {
        String parentTab = driver.getWindowHandle();
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if (!tab.equals(parentTab)) {
                driver.switchTo().window(tab);
                WebElement newTabHeading = driver.findElement(By.id("sampleHeading"));
                System.out.println("Text on the New Tab: " + newTabHeading.getText());
                driver.close();
            }
        }
        driver.switchTo().window(parentTab);
        System.out.println("New Tab button clicked.");
    }

    public static void clickNewWindow() {
        String parentTab = driver.getWindowHandle();
        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        newWindowButton.click();
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if (!tab.equals(parentTab)) {
                driver.switchTo().window(tab);
                WebElement newWindowHeading = driver.findElement(By.id("sampleHeading"));
                System.out.println("Text on the New Window " + newWindowHeading.getText());
                driver.close();
            }
        }
        driver.switchTo().window(parentTab);
        System.out.println("New Window button clicked.");
    }
    public static void clickNewWindowMessage() {
        String parentTab = driver.getWindowHandle();
        WebElement newWindowMessageButton = driver.findElement(By.id("messageWindowButton"));
        newWindowMessageButton.click();
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if (!tab.equals(parentTab)) {
                driver.switchTo().window(tab);
                WebElement newWindowHeading = driver.findElement(By.id("sampleHeading"));
                System.out.println("Text on the New Window Message " + newWindowHeading.getText());
                driver.close();
            }
        }
        driver.switchTo().window(parentTab);
        System.out.println("New Window Message button clicked.");
    }
}


