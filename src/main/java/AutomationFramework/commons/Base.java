package AutomationFramework.commons;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Base {
    public WebDriver driver;
    public static ExtentReports extent;
    public ExtentTest mytest;

    @BeforeSuite(groups = {"Reg","smoke","prod","Dev"})
    public void init_setup(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

@Parameters("browser")

    // to launch the application
    @BeforeMethod(groups = {"Reg","smoke","prod","Dev"})
    public void launchApp(String browser){

        //Switch
        switch (browser) {
            case "edge":
                WebDriverManager.chromedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote -allow-origins=x");
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        driver.get("http://books.rediff.com/");
        driver.manage().window().maximize();
    }
   // to close the application
    @AfterMethod(groups = {"Reg","smoke","prod","Dev"})
    public void TearDown(ITestResult result){
        if (result.getStatus()==ITestResult.FAILURE){
            mytest.log(Status.FAIL,"error occured with Expection:"+result.getThrowable());
        }
        extent.flush();
        driver.close();
    }

    public String getScreenshot() throws IOException{
        TakesScreenshot screen=(TakesScreenshot) driver;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yy hh-mm-ss-SSS");
        String format = simpleDateFormat.format(date);
        String filepath="D:\\New folder\\code\\Screenshot"+format+".png";
        File screenshotAs = screen.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotAs,new File(filepath));
        return filepath;
    }
}
