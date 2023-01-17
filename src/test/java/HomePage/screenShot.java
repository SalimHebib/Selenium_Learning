package HomePage;

import Base.CommonApi;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;


public class screenShot extends CommonApi {


    @Test
    public void ShoppingCart() {
        getDriver().findElement(By.className("shopping_cart_links")).click();


    }


    @Test
    public void AddToCart() {
        getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

    }


    @Test(enabled = true)
    public void skippedTest() {

        int a = 5, b = 6;

        if (a < b) {
            throw new SkipException("Skipping test in TestNG");
        }
    }
}