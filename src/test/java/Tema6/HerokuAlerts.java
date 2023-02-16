package Tema6;

import org.driver.BrowserManager;
import utils.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class HerokuAlerts {
    static ChromeDriver driver = null;

    public static void main(String[] args) throws IOException, InterruptedException, NoSuchElementException {
        navigateToHerokuHomePage();
        try {openAlertsPage();
        openFirstAlert();
        acceptFirstAlert();
        openSecondAlert();
        acceptSecondAlert();
        openThirdAlert();
        completeThirdAlert();
        scrollToSubmitButton();
        }catch (NoSuchElementException e){
            FileUtils.takeScreenshot(driver, "alert");
        }finally {
            BrowserManager.closeBrowser(driver);
        }

    }
    public static void navigateToHerokuHomePage(){
        driver = BrowserManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        System.out.println("Am deschis Heroku index page.");
    }

    public static void openAlertsPage(){
        WebElement alertsLink = driver.findElement(By.id("alerttest"));
        alertsLink.click();
        System.out.println("Am navigat catre AlertsPage.");
    }

    public static void openFirstAlert() {
        WebElement firstAlertButton = driver.findElement(By.id("alertexamples"));
        firstAlertButton.click();
        System.out.println("Am deschis prima alerta.");
    }

    public static void acceptFirstAlert() {
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
        System.out.println("Am acceptat prima alerta.");
    }

    public static void openSecondAlert() throws InterruptedException{
        WebElement secondAlertButton = driver.findElement(By.xpath("//input[@id='confirmexample']"));
        Thread.sleep(2000);
        secondAlertButton.click();
        System.out.println("Am deschis a doua alerta.");
    }

    public static void acceptSecondAlert(){
        Alert secondAlert = driver.switchTo().alert();
        secondAlert.accept();
        System.out.println("Am acceptat a doua alerta.");
    }

    public static void openThirdAlert() throws InterruptedException{
        WebElement thirdAlertButton = driver.findElement(By.xpath("//input[@id='promptexample']"));
        Thread.sleep(2000);
        thirdAlertButton.click();
        System.out.println("Am deschis a treia alerta.");
        }

        public static void completeThirdAlert() {
        Alert thirdAlert = driver.switchTo().alert();
        thirdAlert.sendKeys("I changed you!");
        thirdAlert.accept();
        System.out.println("Am acceptat a treia alerta.");
        System.out.println("Textul afisat dupa alerta este: " + driver.findElement(By.id("promptexplanation")).getText());
        }

        public static void scrollToSubmitButton() {
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).build().perform();
        submitButton.click();
        System.out.println("Am facut scroll catre Submit.");
        }
}
