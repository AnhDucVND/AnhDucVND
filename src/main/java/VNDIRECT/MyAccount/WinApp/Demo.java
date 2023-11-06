package VNDIRECT.MyAccount.WinApp;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;

public class Demo {
    public static void main(String[] args) throws InterruptedException,MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("app","C:\\Windows\\System32\\calc.exe");
        WindowsDriver driver=new WindowsDriver(new URL("http://127.0.0.1:4723/"),cap);
        Thread.sleep(5000);
        driver.quit();

    }
}
