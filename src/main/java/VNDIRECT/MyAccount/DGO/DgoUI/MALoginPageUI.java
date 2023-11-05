package VNDIRECT.MyAccount.DGO.DgoUI;

import org.openqa.selenium.WebDriver;

public class MALoginPageUI {
    public static final String WELCOME_TEXT="//span[contains(text(),'Chào mừng đến với VNDIRECT')]";
    public static final String USERNAME_FIELD="//input[@placeholder='Nhập tên đăng nhập']";
    public static final String PASSWORD_FIELD="//input[@id='typepassword']";
    public static final String BUTTON_LOGIN="//span[contains(text(),'Đăng nhập')]/parent::button";
    public static final String HYPERLINK_CREATENEWACCOUNT="//span[contains(text(),'Mở tài khoản mới')]";

    public static class MAHomeObject {
        public MAHomeObject(WebDriver driver) {
        }
    }
}
