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
    @FindBy(id="srchword")
    public WebElement txt_searchbox;
    @FindBy(xpath = "//input[@type='button' and @value='Search for books']")
    public WebElement btn;
    @FindBy(xpath = "//p[@class='sorrymsg']")
    public WebElement error_msg;
    @FindBy(xpath = "//dic[@id='myDataDiv']/div/p[contains(text(),'Found')]")
    public WebElement validsearch;
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

//    to enter search item
    public void enter_SearchItem(String searchItem){
        txt_searchbox.sendKeys(searchItem);
        btn.click();
    }
    public boolean validerrormessage(String searchItem){
        String actual_output = error_msg.getText();
        String expected_output="Sorry..'"+searchItem+"' does not match any product on Rediff Books";
        if(actual_output.equals(expected_output)){
            return true;
        }else {
            return false;
        }
    }
    public String getSearchCount(){
       return validsearch.getText().split(" ")[1];
    }

}
