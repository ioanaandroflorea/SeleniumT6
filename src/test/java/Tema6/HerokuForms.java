package Tema6;

import org.driver.BrowserManager;
import utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HerokuForms {

    static ChromeDriver driver = null;

    public static void main(String[] args) {
        navigateToHerokuFormsPage();
        fillFormElements();

        try {
            selectSubmitButton();
        } catch (NoSuchElementException e) {
            FileUtils.takeScreenshot(driver, "Heroku Forms");
        } finally {
            BrowserManager.closeBrowser(driver);
        }
    }

    public static void navigateToHerokuFormsPage() {
        driver = BrowserManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        System.out.println("Heroku Forms Page opened.");
    }

    public static void fillFormElements() {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("John Doe");
        System.out.println("Username completed.");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("nothing");
        System.out.println("Password completed.");
        WebElement textAreaComment = driver.findElement(By.name("comments"));
        textAreaComment.sendKeys("Nothing to comment.");
        System.out.println("TextArea Comment completed.");
        WebElement checkboxItems = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[2]"));
        checkboxItems.click();
        System.out.println("Checkbox 2 selected.");
        WebElement radioItems = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[6]/td/input[2]"));
        radioItems.click();;
        System.out.println("Radio 2 selected.");
        WebElement multipleSelectValues = driver.findElement(By.xpath("//*[@id='HTMLFormElements']/table/tbody/tr[7]/td/select/option[2]"));
        multipleSelectValues.click();
        System.out.println("Selection Item 2 selected.");
        WebElement dropdown = driver.findElement(By.name("dropdown"));
        dropdown.click();
        WebElement thirdDropDownItem = driver.findElement(By.xpath("//*[@id='HTMLFormElements']/table/tbody/tr[8]/td/select/option[3]"));
        thirdDropDownItem.click();
        System.out.println("Drop down Item 3 selected.");
    }

    public static void selectSubmitButton() {
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).build().perform();
        submitButton.click();
        System.out.println("I've scrolled to Submit button and selected it.");
    }
}
