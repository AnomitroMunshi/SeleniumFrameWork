package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountsPage;
import utils.Constants;

public class AccountPageTest extends BaseTest {

    @BeforeClass
    public void setAccountPage(){
        accountsPage=login.dologin(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(priority = 3)
    public void accPageTitleTest(){
        String title=accountsPage.getAccTitle();
        Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
    }
}
