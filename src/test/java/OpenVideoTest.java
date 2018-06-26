import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Listeners({TestListener.class})
public class OpenVideoTest extends AbstractTest {
    private static final Logger logger = LogManager.getLogger(OpenVideoTest.class);
    @BeforeClass(description = "Add implicite wait and maximize window")
    public void addImplicitly() {
        // setting standard timeout
        // navigating to test url
        driver.get(main_url);

    }

    @Test()
    public void openVideo() {
        logger.log(Level.INFO, "logging in");
        loginpage.doLogin(Constants.Correct.LOGIN_CORRECT, Constants.Correct.PASSWORD_CORRECT);
        logger.log(Level.INFO, "Openin home page");
        menu.goToHome();
        logger.log(Level.INFO, "Opening video");
        home.openVideo();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(videopage.isOpened(), "Video is not opened");
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        driver.quit();
    }
}