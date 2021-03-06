package test;

import constants.Constants;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners({TestListener.class})
public class OpenVideoTest extends AbstractTest {
    private static final Logger logger = LogManager.getLogger(OpenVideoTest.class);
    private String homeOpenFailed = "Home page is ot opened";
    private String videoOpenFailed = "Video is not opened";
    private String loggerLogIn = "logging in";
    private String loggerOpenHome = "Opening home page";
    private String loggerOpenVideo = "Opening video";
    private String loginFailedMessage = "Looks you are NOT logged in correctly!";

    @BeforeMethod
    public void beforeMethod(){
        init();
    }

    @Test()
    public void openVideo() {
        logger.log(Level.INFO, loggerLogIn);
        loginpage.doLogin(Constants.Correct.LOGIN_CORRECT, Constants.Correct.PASSWORD_CORRECT);
        Assert.assertTrue(menu.isOpened(), loginFailedMessage);
        logger.log(Level.INFO, loggerOpenHome);
        menu.goToHome();
        Assert.assertTrue(home.isOpened(), homeOpenFailed);
        logger.log(Level.INFO, loggerOpenVideo);
        home.openVideo();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(videoPage.isOpened(), videoOpenFailed);
    }
}
