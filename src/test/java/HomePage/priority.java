package HomePage;

import Base.CommonApi;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class priority extends CommonApi {


    @Test(priority = 2)
    public void ClickOnMenu() {

        getDriver().findElement(By.id("react-burger-menu-btn")).click();

    }

    @Test(priority = 1)
    public void MenuDropDown() {
        getDriver().findElement(By.className("product_sort_container")).click();
    }


    @Test(priority = 3)
    public void AddToCart(){
        getDriver().findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

    }
}

