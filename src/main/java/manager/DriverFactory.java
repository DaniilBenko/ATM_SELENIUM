package manager;

import constants.Browsers;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final Logger logger = LogManager.getLogger(DriverFactory.class);

    public static WebDriver setupDriver() {


        Browsers browsers = Browsers.valueOf(ProjectProperties.getProperties().getProperty("browser").toUpperCase());
        System.setProperty(browsers.getKey(), browsers.getPath());
        switch (browsers) {
            case CHROME: {
                logger.log(Level.INFO, "Google Chrome webdriver set with thread name = " + Thread.currentThread().getName());
                return new ChromeDriver();
            }
            case FIREFOX: {
                logger.log(Level.INFO, "Google Chrome webdriver set with thread name = " + Thread.currentThread().getName());
                return new FirefoxDriver();
            }
            default: {
                throw new UnsupportedDriverException("Can not load driver '" + browsers + "'");
            }
        }

    }

}
