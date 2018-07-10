package test;

import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class LoginTest extends AbstractTest {
    private String loginFailedMessage = "Looks you are NOT logged in correctly!";

    @BeforeMethod
    public void beforeMethod() {
        init();
    }

    @Test(description = "Login to YouTube account")
    public void loginToYouTube() {
        loginpage.doLogin(Constants.Correct.LOGIN_CORRECT, Constants.Correct.PASSWORD_CORRECT);
        // Verify the login procedure was correct
        Assert.assertTrue(menu.isOpened(), loginFailedMessage);
    }
}
