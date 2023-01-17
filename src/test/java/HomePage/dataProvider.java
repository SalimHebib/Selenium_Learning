package HomePage;

import Base.CommonApi;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

public class dataProvider extends CommonApi {


    @Test(dataProvider = "LoginTestData")
    public void loginTest(String userName, String password) {

        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("login-button")).click();

        System.out.println("User got successfully Logged in using username :" + userName + " and password :" + password);
    }

    @DataProvider(name="LoginTestData")
    public Object[][] getData() {

        Object[][] data = new Object[4][2];
        data[0][0] = "standard_user";
        data[0][1] = "secret_sauce";

        data[1][0] = "locked_out_user";
        data[1][1] = "secret_sauce";

        data[2][0] = "problem_user";
        data[2][1] = "secret_sauce";

        data[3][0] = "performance_glitch_user";
        data[3][1] = "secret_sauce";

        return data;
    }
}
