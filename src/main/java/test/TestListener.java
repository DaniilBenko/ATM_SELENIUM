package test;

import manager.DriverManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class TestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class);
    protected WebDriver driver = DriverManager.getDriverManager().getDriver();
    protected final String main_url = "https://youtube.com/";

    public void onTestStart(ITestResult iTestResult) {
        logger.log(Level.INFO, iTestResult.getTestClass().getName() + " " + iTestResult.getMethod().getMethodName() + " started");
    }


    public void onTestSuccess(ITestResult iTestResult) {
        logger.log(Level.INFO, iTestResult.getTestClass().getName() + " " + iTestResult.getMethod().getMethodName() + " finished with success");
    }

    public void onTestFailure(ITestResult iTestResult) {
        logger.log(Level.INFO, iTestResult.getTestClass().getName() + " " + iTestResult.getMethod().getMethodName() + " finished with fail");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        logger.log(Level.INFO, iTestResult.getName() + " onTestSkipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logger.log(Level.INFO, iTestResult.getName() + " onTestFailedButWithinSuccessPercentage");
    }

    public void onStart(ITestContext iTestContext) {
        logger.log(Level.INFO, "START");
        driver.get(main_url);
        driver.manage().window().maximize();
    }

    public void onFinish(ITestContext iTestContext) {
        logger.log(Level.INFO, "Finish");
        driver.quit();

    }
}
