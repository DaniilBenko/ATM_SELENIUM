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
public class OpenSubsTest extends AbstractTest {
    private static final Logger logger = LogManager.getLogger(OpenSubsTest.class);
    @BeforeClass(description = "Add implicite wait and maximize window")
    public void addImplicitly() {
        // setting standard timeout
        // navigating to test url
        driver.get(main_url);

    }

    @Test()
    public void goToSubsTest() {
        loginpage.doLogin(Constants.Correct.LOGIN_CORRECT, Constants.Correct.PASSWORD_CORRECT);
        menu.goToSubs();
        Assert.assertTrue(subs.isOpened(), "Subs page is ot opened");
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        driver.quit();
    }
}