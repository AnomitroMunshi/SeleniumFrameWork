package pages;

import org.openqa.selenium.WebDriver;
import utils.Constants;
import utils.Elementutils;

public class AccountsPage {

   private WebDriver driver;
    private Elementutils elementutils;

    public AccountsPage(WebDriver driver){
        this.driver=driver;
        elementutils=new Elementutils(driver);
    }

    public String getAccTitle(){
       return elementutils.waitForTitle(5, Constants.ACCOUNTS_PAGE_TITLE);
    }


}
