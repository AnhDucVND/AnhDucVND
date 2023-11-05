package VNDIRECT.MyAccount.CreateAcount;

import VNDIRECT.MyAccount.CreateAcount.UIs.CreateAccountInfoLoginUI;
import VNDIRECT.MyAccount.DGO.DgoUI.MALoginPageUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountInfoLoginObject extends BasePage {

    private WebDriver driver;

    public CreateAccountInfoLoginObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void inputInfoLogin(String CCCD, String username, String password, String passwordagain) {
        inputToIdentityNoTextbox(CCCD);
        inputToUsernameTextbox(username);
        inputToPasswordTextbox(password);
        inputToPasswordAgainTextbox(passwordagain);
        //clickToAgreeCheckbox();
        //clickToNextButton();

    }

    public void inputToIdentityNoTextbox(String CCCD) {
        waitForElementVisible(driver, CreateAccountInfoLoginUI.CCCD_FIELD);
        sendKeyToElement(driver, CreateAccountInfoLoginUI.CCCD_FIELD, CCCD);
    }

    public void inputToUsernameTextbox(String username) {
        sendKeyToElement(driver, CreateAccountInfoLoginUI.USERNAME_FIELD, username);
    }

    public void inputToPasswordTextbox(String password) {
        sendKeyToElement(driver, CreateAccountInfoLoginUI.PASSWORD_FIELD, password);
    }

    public void inputToPasswordAgainTextbox(String passwordagain) {
        sendKeyToElement(driver, CreateAccountInfoLoginUI.PASSWORDAGAIN_FIELD, passwordagain);
    }

    public void clickToAgreeCheckbox() {
        waitForElementVisible(driver, CreateAccountInfoLoginUI.AGREE_CHECKBOX);
        clickToElement(driver, CreateAccountInfoLoginUI.AGREE_CHECKBOX);
    }

    public void clickToNextButton() {
        waitForElementVisible(driver, CreateAccountInfoLoginUI.NEXT_BUTTON);
        clickToElement(driver, CreateAccountInfoLoginUI.NEXT_BUTTON);
    }

    public String PageText() {
        waitForElementVisible(driver, CreateAccountInfoLoginUI.PAGE_TEXT);
        return getElementText(driver, CreateAccountInfoLoginUI.PAGE_TEXT);
    }

    //THÔNG TIN LIÊN HỆ

    public void inputContactInfo(String fullname, String phonenumber, String email, String contactmethod) {
        inputToFullNameTextbox(fullname);
        inputToPhoneTextbox(phonenumber);
        inputToEmailTextbox(email);
        clickToContactMethod(contactmethod);
    }

    public void inputToFullNameTextbox(String fullname) {
        sendKeyToElement(driver, CreateAccountInfoLoginUI.FULLNAME, fullname);
    }

    public void inputToPhoneTextbox(String phonenumber) {
        sendKeyToElement(driver, CreateAccountInfoLoginUI.PHONE, phonenumber);
    }

    public void inputToEmailTextbox(String email) {
        sendKeyToElement(driver, CreateAccountInfoLoginUI.EMAIL, email);
    }

    public void clickToContactMethod(String contactmethod) {
        switch (contactmethod) {
            case "phone":
                clickToElement(driver, CreateAccountInfoLoginUI.PHONE_RATIOBTN);
                break;
            case "email":
                clickToElement(driver, CreateAccountInfoLoginUI.EMAIL_RATIOBTN);
                break;
        }
    }

    public void clickToCreateAccButton() {
        clickToElement(driver, CreateAccountInfoLoginUI.CREATEACCOUNT_BUTTON);
    }

    public void inputOTP(String OTP){
        for (int i=0;i<=OTP.length()-1;i++){
            char OTP_field=OTP.charAt(i);
            System.out.println(OTP_field);
            sendKeyToElement(driver,CreateAccountInfoLoginUI.OTP_FIELD, String.valueOf(OTP_field));

        }

    }

    public void clickToOTPAccpectButton() {
        clickToElement(driver,CreateAccountInfoLoginUI.OTP_ACCEPT_BUTTON);
    }
}
