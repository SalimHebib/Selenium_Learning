package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


public class CommonApi {


    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;

    }

    Properties prop = Utility.loadProperties();

    String Url = prop.getProperty("URL", "");
    String duration = prop.getProperty("implicit.wait", "10");
    String takeScreenshot = prop.getProperty("take.screenshot", "false");
    String takeScreenshot2 = prop.getProperty("take.screenshot2", "false");
    String takeScreenshot3 = prop.getProperty("take.screenshot3", "false");
    String UserName = prop.getProperty("UserName", "standard_user");
    String Password = prop.getProperty("Password", "secret_sauce");
    String maximizeBrowser = prop.getProperty("maximize.browser", "true");

    @BeforeSuite

    public void BeforeSuite() {

        System.out.println("I execute before suite");
    }

    @Parameters(value = {"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }


        driver.get(Url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(duration)));
        if (maximizeBrowser.equalsIgnoreCase("true")) {
            driver.manage().window().maximize();
        }

        driver.findElement(By.id("user-name")).sendKeys(UserName);
        driver.findElement(By.id("password")).sendKeys(Password);
        driver.findElement(By.name("login-button")).click();

    }


    @AfterMethod

    public void tearDown(ITestResult result) {
        ScreenShot(result);
        driver.quit();
    }

    @AfterSuite
    public void AfterSuite() {

        System.out.println("I execute after suite");

    }


    public void ScreenShot(ITestResult result) {

        String name = result.getName();

        DateFormat df = new SimpleDateFormat("MMddyyyyHHmma");
        Date date = new Date();
        df.format(date);

        File file;

        if (takeScreenshot.equalsIgnoreCase("true"))
            if (result.getStatus() == ITestResult.FAILURE) {
                file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\Screenshots\\ScreenshotsFailedTest\\ " + name + " " + df.format(date) + ".jpeg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            } else if (takeScreenshot2.equalsIgnoreCase("true"))
                if (result.getStatus() == ITestResult.SUCCESS) {
                    file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    try {
                        FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\Screenshots\\ScreenshotsPassedTest\\ " + name + " " + df.format(date) + ".jpeg"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                } else if (takeScreenshot3.equalsIgnoreCase("true"))
                    if (result.getStatus() == ITestResult.SKIP) {
                        file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                        try {
                            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\Screenshots\\ScreenshotsSkippedTest\\ " + name + " " + df.format(date) + ".jpeg"));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }

    }

}



