import constants.Constants;
import manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import youtube.*;

import java.util.concurrent.TimeUnit;

@Listeners({TestListener.class})
public class AllTests {
    private final String main_url = "https://youtube.com/";
    Loginmain loginpage = new Loginmain();
    Menu menu = new Menu();
    Home home = new Home();
    Subs subs = new Subs();
    Videopage videopage = new Videopage();
    WebDriver driver = DriverManager.getDriverManager().getDriver();

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

    @Test(dependsOnMethods = {"loginToYouTube"})
    public void goToSubsTest() {
        menu.goToSubs();
        Assert.assertTrue(subs.isOpened(), "Subs page is ot opened");
    }

    @Test(dependsOnMethods = {"loginToYouTube"})
    public void goToHomeTest() {
        menu.goToHome();
        Assert.assertTrue(home.isOpened(), "Home page is ot opened");
    }

    @Test(dependsOnMethods = {"goToHomeTest"})
    public void openVideo() {
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
