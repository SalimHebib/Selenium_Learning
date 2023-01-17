package Factory;

import Base.CommonApi;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Factory2Test extends CommonApi {

    @Test
    public void AddToCart() {
        getDriver().findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

    }
}
