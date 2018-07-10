package manager;

import org.openqa.selenium.WebDriver;

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

}
