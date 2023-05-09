package AutomationFramework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    //elements
    public WebDriver driver;
    @FindBy(linkText = "Sign In")
    public WebElement lk_signin;

    @FindBy(id = "username")
    public WebElement lblsuccessmessage;
    //constructor
    public HomePage(WebDriver edriver){
        driver=edriver;
        PageFactory.initElements(driver,this);
    }
// action

    public void click_signIN(){
        lk_signin.click();
    }
    public boolean isSuccesfullDisplayed(){
        return lblsuccessmessage.isDisplayed();
    }

}
