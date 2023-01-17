package HomePage;

import Base.CommonApi;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestListeners extends CommonApi {


    @Test
    public void ClickOnMenu() {

        getDriver().findElement(By.id("react-burger-menu-btn")).click();
        getDriver().findElement(By.id("about_sidebar_link")).click();


    }
}
