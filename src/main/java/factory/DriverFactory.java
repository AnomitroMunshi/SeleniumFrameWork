package factory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author AnomitroMunshi
 *
 */
public class DriverFactory {
    public static Logger log= LogManager.getLogger(DriverFactory.class.getName());
    WebDriver driver;
    Properties prop;
    private optionsManager optionsManager;
    public static String highlight = null;


     public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<>();

   /*
   * This returns webdriver
   * */

    public WebDriver init_driver(Properties prop){
        highlight = prop.getProperty("highlight");
        optionsManager =new optionsManager(prop);
        String browserName=prop.getProperty("browser").trim();
        System.out.println("Browser name is "+browserName);

        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
           // driver=new ChromeDriver(optionsManager.getChromeOptions());
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
             tldriver.set(new ChromeDriver(optionsManager.getFirefoxOptions()));
            //driver=new FirefoxDriver(optionsManager.getFirefoxOptions());
        }
        else if(browserName.equalsIgnoreCase("safari")){
            tldriver.set(new SafariDriver());
        }
        else {
            System.out.println("please pass the correct browser : " + browserName);
        }

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().get(prop.getProperty("url").trim());

        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tldriver.get();
    }



    /*
    * Screenshot
    * */
    public String getScreenshot(){
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+ File.separator+"screenshots"+File.separator+System.currentTimeMillis()+".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }


    /*Properties loading
    * */

    public Properties init_prop(){

        FileInputStream ip = null;
        prop = new Properties();
        /*String env= System.getProperty("env");*/
        String env= "PROD";
        System.out.println("Running in env :"+env);
        System.out.println(System.getProperty("user.dir"));
        log.info("running in PROD");

        try{
            switch (env){
                case "PROD":
                    ip = new FileInputStream(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"config.properties");
                    break;
                case "qa":
                    ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
                    break;
                case "stage":
                    ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
                    break;
                case "dev":
                    ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
                    break;
                default:
                    break;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            prop.load(ip);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }




}
