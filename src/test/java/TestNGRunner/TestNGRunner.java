package TestNGRunner;

import Base.CommonApi;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class TestNGRunner extends CommonApi {


    public static void main(String[] args) {

        TestNG objTNG = new TestNG();

        List<String> suites = new ArrayList<String>();

        suites.add("C:\\Users\\hebib\\My Learning\\SeleniumLearning\\src\\test\\resources\\TestNgRun1.xml");
//        suites.add("C:\\Users\\hebib\\My Learning\\SeleniumLearning\\src\\test\\resources\\TestNgRun2.xml");

        //suites.add("C:\\Users\\hebib\\My Learning\\SeleniumLearning\\src\\test\\resources\\HomePageRunner.xml");
        //suites.add("C:\\Users\\hebib\\My Learning\\SeleniumLearning\\src\\test\\resources\\FactoryRunner.xml");
        objTNG.setTestSuites(suites);
        objTNG.run();


    }
}
