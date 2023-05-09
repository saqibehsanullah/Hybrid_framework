package AutomationFramework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
   public WebDriver driver;

   //elements
    @FindBy(name = "logid")
    public WebElement txt_Username;

    @FindBy(name="pswd")
    public WebElement txt_pswd;
    @FindBy(xpath = "//input[@value='Login']")
    public WebElement btn_login;
    @FindBy(xpath = "//b[text()='Sorry we were unable to complete this step because :']" )
    public WebElement lbl_loginErrormsg;
    public SigninPage(WebDriver edriver){
        driver=edriver;
        PageFactory.initElements(driver,this);
    }
    public void enterUserDetails(String username,String password){
        txt_Username.sendKeys(username);
        txt_pswd.sendKeys(password);
        btn_login.click();
    }
    public boolean isErrorMessageDisplayed(){
       return lbl_loginErrormsg.isDisplayed();
    }
}
