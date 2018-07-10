package test;

import constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners({TestListener.class})
public class NavigatingTest extends AbstractTest {
    private static final Logger logger = LogManager.getLogger(OpenVideoTest.class);
    private String loginFailedMessage = "Looks you are NOT logged in correctly!";
    private String feedbackFailedMessage = "Feedback is not opened";
    private String heplFailedMessage = "Help is not opened";
    private String settingsFailedMessage = "Settings is not opened";


    @BeforeMethod
    public void beforeMethod() {
        init();
    }

    @Test
    public void navigating() {
        SoftAssert softA = new SoftAssert();
        loginpage.doLogin(Constants.Correct.LOGIN_CORRECT, Constants.Correct.PASSWORD_CORRECT);
        // Verify the login procedure was correct
        Assert.assertTrue(menu.isOpened(), loginFailedMessage);
        menu.goToFeedback();
        softA.assertTrue(menu.isFeedbackOpened(), feedbackFailedMessage);
        menu.goToHelp();
        softA.assertTrue(menu.isHelpOpened(), heplFailedMessage);
        menu.goToSettings();
        softA.assertTrue(menu.isSettingsOpened(), settingsFailedMessage);
    }
}
