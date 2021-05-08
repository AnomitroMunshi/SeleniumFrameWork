package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class selectdropdown {
public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
        By country= By.id("Form_submitForm_Country");
        By industry=By.id("Form_submitForm_Industry");

        doselectByValue(country,"Algeria");
        doselectByValue(industry,"Electronics");

    }
    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public static void doselectByValue(By locator,String value){
        Select s=new Select(getElement(locator));
        List<WebElement> l=s.getOptions();
        System.out.println("Size "+l.size());

        for(WebElement e:l){
            if(e.getText().equalsIgnoreCase(value)){
                e.click();
                break;
            }
        }

    }
}
