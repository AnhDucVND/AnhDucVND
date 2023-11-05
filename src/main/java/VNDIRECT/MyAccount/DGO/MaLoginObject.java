package VNDIRECT.MyAccount.DGO;

import VNDIRECT.MyAccount.DGO.MAHomeObject;
import VNDIRECT.MyAccount.DGO.DgoUI.MALoginPageUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class MaLoginObject extends BasePage {
    private WebDriver driver;

    public MaLoginObject(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Login to website")
    public MAHomeObject loginWebsite(String username, String password) {
        inputToUsernameTextbox(username);
        inputToPasswordTextbox(password);
        clickToLoginButton(driver);
        waitForLoadingIconInvisible(driver);
        return new MAHomeObject(driver);
    }

    public void inputToUsernameTextbox(String username){
        waitForElementVisible(driver, MALoginPageUI.USERNAME_FIELD);
        sendKeyToElement(driver,MALoginPageUI.USERNAME_FIELD, username);
    }

    public void inputToPasswordTextbox(String password){
        waitForElementVisible(driver, MALoginPageUI.PASSWORD_FIELD);
        sendKeyToElement(driver,MALoginPageUI.PASSWORD_FIELD, password);
    }

    public void clickToLoginButton(WebDriver driver){
        waitForElementVisible(driver, MALoginPageUI.BUTTON_LOGIN);
        clickToElement(driver,MALoginPageUI.BUTTON_LOGIN);
    }

    public void clickToHyperlinkCreateNewAcc(){
        waitForElementVisible(driver, MALoginPageUI.HYPERLINK_CREATENEWACCOUNT);
        clickToElement(driver,MALoginPageUI.HYPERLINK_CREATENEWACCOUNT);
    }

    public String welcomeText() {
        waitForElementVisible(driver, MALoginPageUI.WELCOME_TEXT);
        return getElementText(driver, MALoginPageUI.WELCOME_TEXT);
    }
}
