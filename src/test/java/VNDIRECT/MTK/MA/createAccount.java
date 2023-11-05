package VNDIRECT.MTK.MA;

import NPT.NptPageObjects.NptHomePageObject;
import NPT.NptPageObjects.NptLoginPageObject;
import VNDIRECT.MyAccount.CreateAcount.CreateAccountInfoLoginObject;
import VNDIRECT.MyAccount.CreateAcount.InfoContact;
import VNDIRECT.MyAccount.DGO.MaLoginObject;
import commons.BasePage;
import commons.BasePageUI;
import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import commons.BasePage;
import VNDIRECT.MyAccount.CreateAcount.UIs.*;

import static commons.GlobalConstants.NPT_LOGIN;
import static commons.GlobalConstants.*;

public class createAccount extends BaseTest {
    WebDriver driver;
    private String CCCD, username,password, passwordagain, fullname,phonenumber,email,contactmethod;
    private String browserName;
    private CreateAccountInfoLoginObject createAccountInfoLoginObject;
    private MaLoginObject loginMA;



    @BeforeClass
    public void beforeClass(){
        browserName = "chrome";
        driver = getBrowserDriver(browserName, URL_MYACC);
        loginMA = new MaLoginObject(driver);
        createAccountInfoLoginObject = new CreateAccountInfoLoginObject(driver);
        BasePage basePage=new BasePage();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        CCCD = "354654567";
        password = "12345678";
        passwordagain=password;
        username="duc234234";
        fullname="NGUYỄN ANH ĐỨC";
        phonenumber="0345328843";
        email=phonenumber+"@gmail.com";
        contactmethod="email";

    }

    @Test
    public void TC_01(Method method) throws Exception {
        BasePage basePage=new BasePage();
        loginMA.clickToHyperlinkCreateNewAcc();
        Assert.assertEquals(createAccountInfoLoginObject.PageText(),"Thông tin đăng nhập","không phải màn nhập thông tin");
        createAccountInfoLoginObject.inputInfoLogin(CCCD,username,password,password);
        basePage.wait(3);
        createAccountInfoLoginObject.clickToAgreeCheckbox();
        basePage.wait(5);
        createAccountInfoLoginObject.clickToNextButton();
        basePage.wait(5);
        createAccountInfoLoginObject.inputContactInfo(fullname,phonenumber,email,contactmethod);
        basePage.wait(3);
        createAccountInfoLoginObject.clickToCreateAccButton();
        basePage.wait(10);
        createAccountInfoLoginObject.inputOTP("898989");
        basePage.wait(5);
        createAccountInfoLoginObject.clickToOTPAccpectButton();
        basePage.wait(5);

    }

}




