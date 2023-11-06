package VNDIRECT.MTK.MA;

import NPT.NptPageObjects.NptHomePageObject;
import NPT.NptPageObjects.NptLoginPageObject;
import VNDIRECT.MyAccount.APIs.APIRequestKeyword;
import VNDIRECT.MyAccount.APIs.APIUtilities;
import VNDIRECT.MyAccount.APIs.WebServiceObject;
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

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import commons.BasePage;
import VNDIRECT.MyAccount.CreateAcount.UIs.*;

import static commons.GlobalConstants.NPT_LOGIN;
import static commons.GlobalConstants.*;

//Winapp
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import io.appium.java_client.windows.WindowsDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class createAccount extends BaseTest {
    WebDriver driver;
    private String CCCD, username,password, passwordagain, fullname,phonenumber,email,contactmethod;
    private String browserName;
    private CreateAccountInfoLoginObject createAccountInfoLoginObject;
    private MaLoginObject loginMA;

    //Winapp
    WindowsDriver driver1 = null;
    public static String status = "passed";
    /* Application Path */
    public String appPath="Microsoft.WindowsCalculator_8wekyb3d8bbwe!App";


    @BeforeTest
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
    @Test(priority = 0)
    public void TC_01(Method method) throws Exception {
        BasePage basePage=new BasePage();
        loginMA.clickToHyperlinkCreateNewAcc();
        Assert.assertEquals(createAccountInfoLoginObject.PageText(),"Thông tin đăng nhập","không phải màn nhập thông tin");
        createAccountInfoLoginObject.inputInfoLogin(CCCD,username,password,password);
        basePage.wait(3);
//        createAccountInfoLoginObject.clickToAgreeCheckbox();
//        basePage.wait(5);
//        createAccountInfoLoginObject.clickToNextButton();
//        basePage.wait(5);
//        createAccountInfoLoginObject.inputContactInfo(fullname,phonenumber,email,contactmethod);
//        basePage.wait(3);
//        createAccountInfoLoginObject.clickToCreateAccButton();
//        basePage.wait(10);
//        createAccountInfoLoginObject.inputOTP("898989");
//        basePage.wait(5);
//        createAccountInfoLoginObject.clickToOTPAccpectButton();
//        basePage.wait(5);
    }

//    @BeforeMethod
//    public void testSetUp() throws Exception
//    {
//        DesiredCapabilities capability = new DesiredCapabilities();
//
//        //capability.setCapability("ms:experimental-webdriver", true);
//        capability.setCapability("app",appPath);
//        // capability.setCapability("platformName", "Windows");
//        // capability.setCapability("deviceName", "Windows10Machine");
//
//        /* Start WinAppDriver.exe so that it can start listening to incoming requests */
//
//        String winappDriverPath="C:\\Program Files\\Windows Application Driver\\WinAppDriver.exe";
//        ProcessBuilder bulider= new ProcessBuilder(winappDriverPath).inheritIO();
//        Process process=bulider.start();
//
//        driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), capability);
//    }

    @Test(description="Demonstration of Mouse Actions using ActionChains",priority = 1)
    public void test_mouse_interactions() throws InterruptedException, IOException {

        DesiredCapabilities capability = new DesiredCapabilities();

        //capability.setCapability("ms:experimental-webdriver", true);
        capability.setCapability("app",appPath);
        // capability.setCapability("platformName", "Windows");
        // capability.setCapability("deviceName", "Windows10Machine");

        /* Start WinAppDriver.exe so that it can start listening to incoming requests */

        String winappDriverPath="C:\\Program Files\\Windows Application Driver\\WinAppDriver.exe";
        ProcessBuilder bulider= new ProcessBuilder(winappDriverPath).inheritIO();
        Process process=bulider.start();

        driver1 = new WindowsDriver(new URL("http://127.0.0.1:4723/"), capability);
        /* create an object for the Actions class and pass the driver argument */
        Actions action = new Actions(driver1);

        /* Click on the Toggle Menu button */
        WebElement menuItem = driver1.findElementByAccessibilityId("TogglePaneButton");
        action.click(menuItem);
        action.perform();

        /* Blocking Sleep - Used only for demo, Explicit Sleep is preferred */
        Thread.sleep(3000);

        /* Click on the Scientific item in the Menu */
        WebElement scientific = driver1.findElementByAccessibilityId("Standard");
        action.click(scientific);
        action.perform();

        /* Can Assert if required */
        driver1.findElementByAccessibilityId("num1Button").click();

        /* Use the Name property for locating the buttons and performing click operation */
        driver1.findElement(By.name("Plus")).click();
        driver1.findElement(By.name("Nine")).click();
        action.sendKeys(Keys.ENTER).build().perform();

        action.sendKeys(Keys.ENTER).build().perform();

        /* Blocking Sleep - Not a good practice, used only for demo */
        driver1.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        /* The result should be 10, assert if the result pane does not show 10 */
        WebElement resultsElement = driver1.findElementByAccessibilityId("CalculatorResults");

        String resultantText = "10";
        String resultsElementText = resultsElement.getText().replace("Display is","").trim();

        /* Assert if the result is not 10 */
        Assert.assertEquals(resultantText, resultsElementText);
    }

//    @Test(description="Demonstration of Button click", priority = 1)
//    public void button_click_interactions() throws InterruptedException
//    {
//        /* Option 1: Click on Button - 1 by identifying it using name property */
//        /* driver.findElement(By.name("One")).click(); */
//
//        /* Option 2: Click on Button - 1 by identifying it using AccessibilityID property */
//        driver1.findElementByAccessibilityId("num1Button").click();
//
//        /* Use the Name property for locating the buttons and performing click operation */
//        driver.findElement(By.name("Plus")).click();
//        driver.findElement(By.name("Nine")).click();
//        driver.findElement(By.name("Equals")).click();
//
//        /* Blocking Sleep - Not a good practice, used only for demo */
//        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
//
//        /* The result should be 10, assert if the result pane does not show 10 */
//        WebElement resultsElement = driver1.findElementByAccessibilityId("CalculatorResults");
//
//        String resultantText = "10";
//        String resultsElementText = resultsElement.getText().replace("Display is","").trim();
//
//        /* Assert if the result is not 10 */
//        Assert.assertEquals(resultantText, resultsElementText);
//    }



//    @Test
//    public void TC02() throws IOException {
//
//        WebServiceObject api1=new WebServiceObject("https://pokeapi.co/api/v2/version/1/",null,"POST",null);
//
//        APIRequestKeyword apiRequestKeyword=new APIRequestKeyword();
//        System.out.println(apiRequestKeyword.sendAPIRequest(api1).toString());
//        System.out.println(apiRequestKeyword.sendAPIRequest(api1));
//
//
//
//    }

}




