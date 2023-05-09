package AutomationFramework.TestScripts;

import AutomationFramework.DataProvider.D_Login;
import AutomationFramework.Pages.HomePage;
import AutomationFramework.Pages.SigninPage;
import AutomationFramework.commons.Base;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.io.IOException;

public class Script_Login_secondBackup extends Base {
    @Test(dataProvider = "validLogin",dataProviderClass = D_Login.class,groups = {"Reg","smoke"})
    public void valid_login(String TC_ID,String script,String username,String password) throws IOException {
        HomePage homePage=new HomePage(driver);
        SigninPage signinPage = new SigninPage(driver);
        mytest = extent.createTest(TC_ID);
        mytest.log(Status.PASS,"Successfully lauched application");
        //click on sign In
     //   driver.findElement(By.linkText("Sign In")).click();
       homePage.click_signIN();
        //enter login details
       // driver.findElement(By.name("logid")).sendKeys(username);
       // driver.findElement(By.name("pswd")).sendKeys(password);
//        driver.findElement(By.xpath("//input[@value='Login']")).click();
        signinPage.enterUserDetails(username,password);
        mytest.log(Status.PASS,"Successfully entered the details in  application");

        boolean login_username = homePage.isSuccesfullDisplayed();
        if (login_username){
            System.out.println(TC_ID+"PASS");
            mytest.log(Status.PASS,"The output is pass when output is "+ login_username, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());

        }else {
            System.out.println(TC_ID+"FAIL");
            mytest.log(Status.PASS,"The output is fail when output is "+ login_username, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());

        }

    }

    @Test(dataProvider = "invalidLogin",dataProviderClass = D_Login.class,groups = {"reg","prod","Dev"})
    public void invalid_login(String Tc_ID,String Script,String username,String password) throws IOException {
        HomePage homePage = new HomePage(driver);
        SigninPage signinPage = new SigninPage(driver);
        mytest = extent.createTest(Tc_ID);
        mytest.log(Status.PASS,"Successfully lauched application");

        //click on sign In
        homePage.click_signIN();
        //driver.findElement(By.linkText("Sign In")).click();
        //enter login details
        signinPage.enterUserDetails(username,password);
        mytest.log(Status.PASS,"Successfully the entered the details");


        //driver.findElement(By.name("logid")).sendKeys(username);
        //driver.findElement(By.name("pswd")).sendKeys(password);
        //driver.findElement(By.xpath("//input[@value='Login']")).click();

        boolean displayed =signinPage.isErrorMessageDisplayed();
               // driver.findElement(By.xpath("//b[text()=' Sorry we were unable to complete this step because :")).isDisplayed();
        if (displayed){
            System.out.println(Tc_ID+"PASS");
            mytest.log(Status.PASS,"The output is pass when output is "+displayed, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());

        }else {
            System.out.println(Tc_ID+"FAIL");
            mytest.log(Status.PASS,"The output is fail when output is "+displayed, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());

        }

    }









}
