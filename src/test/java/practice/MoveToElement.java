package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElement {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146");

        moveToElement(By.xpath("//a[@class='menulink']"));
        Thread.sleep(3000);
        moveToElementAndClick(By.linkText("COURSES"));

    }
    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public static void moveToElement(By locator){
        Actions ac=new Actions(driver);
        ac.moveToElement(getElement(locator)).build().perform();
    }

    public static void moveToElementAndClick(By locator){
        moveToElement(locator);
        getElement(locator).click();
    }

}
