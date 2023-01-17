package TestNGRunner;

import Base.CommonApi;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestNgClass2 extends CommonApi {

    @Test
    public void MenuDropDown() {
        getDriver().findElement(By.className("product_sort_container")).click();
    }

}
