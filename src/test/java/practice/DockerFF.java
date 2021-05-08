package practice;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DockerFF {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc=DesiredCapabilities.firefox();

        //docker run -d -p 4444:4444 -v /dev/shm:/dev/shm henningn/selenium-standalone-firefox:latest
        URL url=new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver=new RemoteWebDriver(url,dc);
        driver.get("https://demo.opencart.com/");
        System.out.println("The title of page is : "+driver.getTitle());
        driver.quit();
    }
}
