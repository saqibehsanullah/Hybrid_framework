package AutomationFramework.TestScripts;

import AutomationFramework.DataProvider.D_Login;
import AutomationFramework.commons.Base;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Script_login_backup extends Base {
    @Test(dataProvider = "validLogin", dataProviderClass = D_Login.class)
    public void valid_login(String TC_ID, String script, String username, String password) {

        //click on sign In
        driver.findElement(By.linkText("Sign In")).click();

        //enter login details
        driver.findElement(By.name("logid")).sendKeys(username);
        driver.findElement(By.name("pswd")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        boolean login_username = driver.findElement(By.id("username")).isDisplayed();
        if (login_username) {
            System.out.println(TC_ID + "PASS");
        } else {
            System.out.println(TC_ID + "FAIL");
        }

    }

    @Test(dataProvider = "invalidLogin", dataProviderClass = D_Login.class)
    public void invalid_login(String Tc_ID, String Script, String username, String password) {

        //click on sign In

        driver.findElement(By.linkText("Sign In")).click();
        //enter login details


        driver.findElement(By.name("logid")).sendKeys(username);
        driver.findElement(By.name("pswd")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        boolean displayed = driver.findElement(By.xpath("//b[text()='Sorry we were unable to complete this step because :']")).isDisplayed();
        if (displayed) {
            System.out.println(Tc_ID + "PASS");
        } else {
            System.out.println(Tc_ID + "FAIL");
        }
    }
}
