package test;

import constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import youtube.Subs;


@Listeners({TestListener.class})
public class OpenHomeTest extends AbstractTest {
    private String homeOpenFailed = "Home page is ot opened";
    private String loginFailedMessage = "Looks you are NOT logged in correctly!";
    private String subsFailedMessage = "Looks you are NOT in subscriptions page!";
    private static final Logger logger = LogManager.getLogger(OpenHomeTest.class);

    @Test()
    public void goToHomeTest() {
        SoftAssert softA= new SoftAssert();
        loginpage.doLogin(Constants.Correct.LOGIN_CORRECT, Constants.Correct.PASSWORD_CORRECT);
        Assert.assertTrue(menu.isOpened(), loginFailedMessage);
        menu.goToSubs();
        menu.goToHome();
        softA.assertTrue(subs.isOpened(), subsFailedMessage);
        Assert.assertTrue(home.isOpened(), homeOpenFailed);
    }
}
