package Methods;

import Base.CommonApi;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IncludeTest extends CommonApi {

    @Test
    public void ClickOnMenu() {

        getDriver().findElement(By.id("react-burger-menu-btn")).click();

    }

    @Test
    public void MenuDropDown() {
        getDriver().findElement(By.className("product_sort_container")).click();
    }


    @Test(groups = {"Smoking"})
    public void AddToCart(){
        getDriver().findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

    }
}

