package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
    String captureScreenshot = prop.getProperty("capture.screenshot", "false");
    String takeCapture = prop.getProperty("take.capture", "false");
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
        screenShotAfterEachTestMethod(result);
        driver.quit();
    }

    @AfterSuite
    public void AfterSuite() {

        System.out.println("I execute after suite");

    }


    public void takeScreenshot(String screenshotName) {
        DateFormat df = new SimpleDateFormat("MMddyyyyHHmma");
        Date date = new Date();
        df.format(date);

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\ScreenshotsFailedTest\\" + screenshotName + " " + df.format(date) + ".jpeg"));

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void takePicture(String name) {

        DateFormat df = new SimpleDateFormat("MMddyyyyHHmma");
        Date date = new Date();
        df.format(date);

        if (captureScreenshot.equalsIgnoreCase("true")) {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\ScreenshotsPassedTests\\ " + name + " " + df.format(date) + ".jpeg"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void photographer(String name) {
        DateFormat df = new SimpleDateFormat("MMddyyyyHHmma");
        Date date = new Date();
        df.format(date);

        if (takeCapture.equalsIgnoreCase("true")) {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\ScreenshotsIgnoredTests\\ " + name + " " + df.format(date) + ".jpeg"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void screenShotAfterEachTestMethod(ITestResult result) {
        if (takeScreenshot.equalsIgnoreCase("true"))
            if (result.getStatus() == ITestResult.FAILURE) {
                takeScreenshot(result.getName());
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                takePicture(result.getName());
            } else if (result.getStatus() == ITestResult.SKIP) {
                photographer(result.getName());
            }


    }

}

