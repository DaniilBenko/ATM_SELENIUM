import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Listeners({TestListener.class})
public class LoginTest extends AbstractTest {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    @BeforeClass(description = "Add implicite wait and maximize window")
    public void addImplicitly() {
        // setting standard timeout
        // navigating to test url
        driver.get(main_url);

    }

    @Test(description = "Login to YouTube account")
    public void loginToYouTube() {
        loginpage.doLogin(Constants.Correct.LOGIN_CORRECT, Constants.Correct.PASSWORD_CORRECT);
        // Verify the login procedure was correct
        Assert.assertTrue(menu.isOpened(), "Looks you are NOT logged in correctly!");
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        driver.quit();
    }
}
