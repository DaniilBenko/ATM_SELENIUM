package test;

import constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class OpenSubsTest extends AbstractTest {
    private static final Logger logger = LogManager.getLogger(OpenSubsTest.class);
    private String subscriptionsOpenFailed = "Subs page is ot opened";
    private String loginFailedMessage = "Looks you are NOT logged in correctly!";


    @Test()
    public void goToSubsTest() {
        loginpage.doLogin(Constants.Correct.LOGIN_CORRECT, Constants.Correct.PASSWORD_CORRECT);
        Assert.assertTrue(menu.isOpened(), loginFailedMessage);
        menu.goToSubs();
        Assert.assertTrue(subs.isOpened(), subscriptionsOpenFailed);
    }

}
