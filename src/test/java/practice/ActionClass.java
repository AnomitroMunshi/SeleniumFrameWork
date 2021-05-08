package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {
    public static WebDriver driver;
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt=new ChromeOptions();

        driver=new ChromeDriver(opt.addArguments("--incognito"));

        driver.get("https://demo.opencart.com/index.php?route=account/login");

        By emailId = By.id("input-email");
        By password = By.id("input-password");
        By loginButton = By.xpath("//input[@type='submit']");

        doActionsSendKeys(emailId,"anomitro.munshi4@gmail.com");
        doActionsSendKeys(password,"admin123");
        doActionsClick(loginButton);

    }

    public static WebElement getElement(By locator) {

        return driver.findElement(locator);
    }

    public static void doActionsSendKeys(By locator, String value) {
        Actions act = new Actions(driver);
        act.sendKeys(getElement(locator), value).perform();

    }

    public static void doActionsClick(By locator) {
        Actions act = new Actions(driver);
        act.moveToElement(getElement(locator)).click(getElement(locator)).perform();
    }
}
