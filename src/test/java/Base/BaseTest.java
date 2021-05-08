package Base;

import com.aventstack.extentreports.TestListener;
import factory.DriverFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.AccountsPage;
import pages.LoginPage;
import Listeners.AllureListener;

import java.util.Properties;

@Listeners(AllureListener.class)
public class BaseTest {
    public static Logger log= LogManager.getLogger(BaseTest.class.getName());
   public  WebDriver driver;
   public Properties prop;
   public LoginPage login;
   public AccountsPage accountsPage;
   DriverFactory df;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browserName){
        df=new DriverFactory();
        prop=df.init_prop();
        prop.setProperty("browser",browserName);
        driver=df.init_driver(prop);
        login=new LoginPage(driver);


    }

    @AfterTest
    public void teardown(){
        //driver.quit();
    }
}
