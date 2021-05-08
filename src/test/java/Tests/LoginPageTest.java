package Tests;

import Base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Constants;

public class LoginPageTest extends BaseTest {

    @Test(priority = 0)
    @Description("Verify loginPageTitle")
    public void chckLoginPageTitleTest(){
        String title=login.getLoginPageTitle();
        System.out.println("Title is :"+title);
        Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 1)
    @Description("Verify loginPageURL")
    public void chckLoginPageURLTest(){
        String url=login.getLoginPageURL();
        System.out.println(url);
        Assert.assertTrue(url.contains(Constants.LOGIN_URL_VALUE));
    }

    @Test(priority = 1)
    @Description("Verify Password link is present")
    public void chckPasswordLinkExistTest(){
        boolean exists=login.isForgotPwdLinkExist();
        Assert.assertTrue(exists);
    }


    @Test(priority = 3)
    @Description("Verify Login")
    public void Logintest(){
        login.dologin(prop.getProperty("username"),prop.getProperty("password"));
    }


    @Test(priority = 0, dataProvider = "loginNegativeDatas")
    public void loginNegativeTest(String un, String pss){
        login.doWronglogin(un,pss);
    }

    @DataProvider
    public Object[][] loginNegativeDatas(){
        return new Object[][] {
                {"Ano","SomePass"},{"","admin123"},{"",""}
        };
    }


}
