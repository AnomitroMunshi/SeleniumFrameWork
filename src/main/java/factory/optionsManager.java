package factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class optionsManager {
    private ChromeOptions chromeOptions;
    private FirefoxOptions firefoxOptions;
    private Properties prop;

    public optionsManager(Properties properties){
        this.prop=properties;
    }

    public ChromeOptions getChromeOptions() {
        chromeOptions=new ChromeOptions();
        if(Boolean.parseBoolean(prop.getProperty("headless").trim()))
          chromeOptions.addArguments("--headless");

        if(Boolean.parseBoolean(prop.getProperty("incognito").trim()))
            chromeOptions.addArguments("--incognito");
        return chromeOptions;
    }
    public FirefoxOptions getFirefoxOptions(){
        firefoxOptions=new FirefoxOptions();
        if(Boolean.parseBoolean(prop.getProperty("headless").trim()))
            firefoxOptions.addArguments("--headless");
        if(Boolean.parseBoolean(prop.getProperty("incognito").trim()))
            firefoxOptions.addArguments("--incognito");
        return firefoxOptions;
    }

}
