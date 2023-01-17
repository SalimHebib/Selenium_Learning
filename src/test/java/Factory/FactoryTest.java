package Factory;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryTest {

    @Test
    @Factory
    public Object[] RunTest(){

        return new Object[]{new Factory1Test(),new Factory2Test()};

    }
}
