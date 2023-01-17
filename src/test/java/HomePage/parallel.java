package HomePage;

import Base.CommonApi;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class parallel extends CommonApi {



//     to run it disable login from commonApi

    @Test
    public void Logo() {

        getDriver().findElement(By.className("login_logo")).isDisplayed();


    }

    @Test
    public void LoginButton() {
        getDriver().findElement(By.id("login-button")).isDisplayed();
    }


}
