package HomePage;

import Base.CommonApi;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class assertion extends CommonApi {

    @Test
    public void AppLogo(){
        Assert.assertTrue(getDriver().findElement(By.className("app_logo")).isDisplayed());

    }
}
