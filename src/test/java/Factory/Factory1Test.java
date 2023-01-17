package Factory;

import Base.CommonApi;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Factory1Test extends CommonApi {

    @Test
    public void ClickOnMenu() {

        getDriver().findElement(By.id("react-burger-menu-btn")).click();

    }

    @Test
    public void MenuDropDown() {
        getDriver().findElement(By.className("product_sort_container")).click();
    }
}