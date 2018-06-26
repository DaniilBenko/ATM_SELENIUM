package manager;

import constants.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestNGException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static DriverManager driverManager;
    private WebDriver driver;

    private DriverManager() {

       driver = DriverFactory.setupDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

    }

    public static DriverManager getDriverManager() {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    public WebDriver getDriver() {
        return driver;
    }
//private static final Logger logger = LogManager.getLogger(DriverManager.class);
//
//    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
//        @Override
//        protected WebDriver initialValue() {
//            WebDriver webDriver = DriverFactory.setupDriver();
//            webDriver.manage().window().maximize();
//            webDriver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
//            webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return webDriver;
//        }
//    };
//
//    private DriverManager() {
//    }
//
//    private static class InnerInit {
//        private static final DriverManager instance = new DriverManager();
//    }
//    public static DriverManager getInstance() {
//        return InnerInit.instance;
//    }
//
//    public WebDriver getDriver() // call this method to get the driver object and launch the browser
//    {
//        return driver.get();
//    }
//
//    public void removeDriver() // Quits the driver and closes the browser
//    {
//        logger.log(Level.INFO, "try to quite driver");
//        driver.get().quit();
//        driver.remove();
//    }

}
