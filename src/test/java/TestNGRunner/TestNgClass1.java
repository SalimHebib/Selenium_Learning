package TestNGRunner;

import Base.CommonApi;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestNgClass1 extends CommonApi {

    @Test
    public void ClickOnMenu() {

        getDriver().findElement(By.id("react-burger-menu-btn")).click();
    }
}