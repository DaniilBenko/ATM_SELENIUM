import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("TEST START");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("TEST SUCCESS");
        System.out.println(iTestResult.getName());
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("TEST FAILURE");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("TEST SKIPPED");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test Failed But Within Success Percentage");
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("START");
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("Finish");
    }
}
