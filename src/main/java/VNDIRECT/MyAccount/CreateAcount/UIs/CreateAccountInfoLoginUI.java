package VNDIRECT.MyAccount.CreateAcount.UIs;

public class CreateAccountInfoLoginUI {

    // THông tin đăng nhập
    public static final String PAGE_TEXT="//span[contains(text(),'Thông tin đăng nhập')]";
    public static final String CCCD_FIELD="//input[@placeholder='Nhập số CMND/CCCD']";

    public static final String USERNAME_FIELD="//input[@placeholder='Nhập tên đăng nhập']";
    public static final String PASSWORD_FIELD="//input[@id='typepassword']";
    public static final String PASSWORDAGAIN_FIELD="//input[@id='typepasswordagain']";
    public static final String AGREE_CHECKBOX="(//input[@id='agree-checkbox']/following-sibling::span)[1]";
    public static final String NEXT_BUTTON="//span[contains(text(),'Về trang đăng nhập')]/preceding-sibling::*";
    public static final String BACKTOLOGIN_BUTTON="//span[contains(text(),'Về trang đăng nhập')]";


    //Thông tin liên hệ
    public static final String FULLNAME="//input[@placeholder='Nhập họ và tên trên CMND/CCCD']";
    public static final String PHONE="//input[@placeholder='Nhập số điện thoại di động']";
    public static final String EMAIL="//input[@placeholder='Nhập địa chỉ email']";
    public static final String PHONE_RATIOBTN="//span[contains(text(),'Điện thoại di động')]/parent::label";
    public static final String EMAIL_RATIOBTN="//span[contains(text(),'Email')]/parent::label";
    public static final String CREATEACCOUNT_BUTTON="//button[contains(text(),'Tạo tài khoản')]";
    public static final String BACK_BUTTON="//span[contains(text(),'Quay lại')]";

    public static final String OTP_FIELD="//input[@class='input  ']";
    public static final String OTP_ACCEPT_BUTTON="//button[text()='Xác nhận']";



}
