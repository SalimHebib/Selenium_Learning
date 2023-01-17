package HomePage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class listeners implements ITestListener {


    public void onTestStart(ITestResult result) {
        System.out.println("Test Execution Started for " + result.getName());
    }


    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Execution Successfully for "+ result.getName());
    }


    public void onTestFailure(ITestResult result) {
        System.out.println("Test Execution Failed");
    }


    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Execution Skipped");
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {
        System.out.println("Execution Start Successfully for " + context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("Execution Ended Successfully for "+ context.getName());
    }


}
