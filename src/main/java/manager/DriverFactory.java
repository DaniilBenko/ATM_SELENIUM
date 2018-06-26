package manager;

import constants.Browsers;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.logging.log4j.Logger;

public class DriverFactory {
    private static final Logger logger = LogManager.getLogger(DriverFactory.class);

    public static WebDriver setupDriver() {


        Browsers browsers = Browsers.valueOf(ProjectProperties.getProperties().getProperty("browser").toUpperCase());
        System.setProperty(browsers.getKey(), browsers.getPath());
        //System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        //driver = new ChromeDriver();
        switch (browsers){
            case CHROME: {
                //logger.log(Level.INFO, "Google Chrome webdriver set with thread name = "+Thread.currentThread().getName());
               return new ChromeDriver();
            }
            case FIREFOX: {
                //logger.log(Level.INFO, "Google Chrome webdriver set with thread name = "+Thread.currentThread().getName());
                return new FirefoxDriver();
            }
        default: return new ChromeDriver();
        }

    }

}
