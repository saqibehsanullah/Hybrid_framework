package AutomationFramework.TestScripts;

import AutomationFramework.DataProvider.Dp_Search;
import AutomationFramework.Pages.HomePage;
import AutomationFramework.commons.Base;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Script_Search extends Base {
    @Test(dataProvider = "invalidSearch",dataProviderClass = Dp_Search.class,groups = {"reg","prod","Dev"})
    public void invalidSearch(String Tc_ID,String Script,String searchItem,String expectedcount) throws IOException {
        HomePage homePage = new HomePage(driver);
        mytest = extent.createTest(Tc_ID);
        Assert.assertTrue(driver.getTitle().contains("Buy Books Online"),"Titlle is not matching");
        mytest.log(Status.PASS,"Successfully lauched application");
        //click on sign In

        homePage.enter_SearchItem(searchItem);
        mytest.log(Status.PASS,"Successfully lauched application");
        Assert.assertTrue(homePage.validerrormessage(searchItem),"error message not displayed");
        mytest.log(Status.PASS,Tc_ID+"has successfully passed");
    }
    @Test(dataProvider = "validSearch",dataProviderClass = Dp_Search.class,groups = {"reg","prod","Dev"})
    public void validSearch(String Tc_ID,String Script,String searchItem,String expectedCount) throws IOException {
        HomePage homePage = new HomePage(driver);
        mytest = extent.createTest(Tc_ID);
        Assert.assertTrue(driver.getTitle().contains("Buy Books Online"),"Titlle is not matching");
        mytest.log(Status.PASS,"Successfully lauched application");
        //click on sign In

        homePage.enter_SearchItem(searchItem);
        mytest.log(Status.PASS,"Successfully lauched application");
        Assert.assertEquals(homePage.getSearchCount(),expectedCount.replace(".0"," "),"error message not displayed");
        mytest.log(Status.PASS,Tc_ID+"has successfully passed");
    }










}
