package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Constants;
import utils.Elementutils;

public class LoginPage {

    private WebDriver driver;
    private Elementutils elementUtil;

    //Locators
    private By username= By.id("input-email");
    private By password = By.id("input-password");
    private By loginButton = By.xpath("//input[@type='submit']");
    private By forgotLink = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
    private By registerLink = By.linkText("Register");
    private By Loginerror=By.cssSelector("div[class='alert alert-danger alert-dismissible']");

    //Constructor
    public LoginPage(WebDriver driver){
        this.driver=driver;
        elementUtil=new Elementutils(driver);
    }

    //Page Actions
    public String getLoginPageTitle(){
        return elementUtil.waitForTitle(5, Constants.LOGIN_PAGE_TITLE);
    }


    public String getLoginPageURL() {
        return elementUtil.getPageUrl();
    }

    public boolean isForgotPwdLinkExist(){
        return elementUtil.doIsDisplayed(forgotLink);
    }

    @Step("login with username : {0} and password : {1}")
    public AccountsPage dologin(String user,String pass){
        elementUtil.doSendKeys(username,user);
        elementUtil.doSendKeys(password,pass);
        elementUtil.doActionsClick(loginButton);

        return new AccountsPage(driver);
    }

    @Step("login with username : {0} and password : {1}")
    public boolean doWronglogin(String un, String pss) {
        elementUtil.doSendKeys(username,un);
        elementUtil.doSendKeys(password,pss);
        elementUtil.doActionsClick(loginButton);
        return elementUtil.doIsDisplayed(Loginerror);
    }
}
