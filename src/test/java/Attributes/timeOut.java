package Attributes;

import Base.CommonApi;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class timeOut extends CommonApi {


    @Test
    public void ClickOnMenu() {

        getDriver().findElement(By.id("react-burger-menu-btn")).click();

    }

    @Test(timeOut = 10000)
    public void MenuDropDown() throws InterruptedException {
        getDriver().findElement(By.className("product_sort_container")).click();
        Thread.sleep(9000);
    }


    @Test
    public void AddToCart(){
        getDriver().findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

    }
}

