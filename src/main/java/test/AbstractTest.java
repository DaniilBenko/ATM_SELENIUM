package test;

import manager.DriverManager;
import org.openqa.selenium.WebDriver;
import youtube.*;

public abstract class AbstractTest {
    protected LoginMain loginpage;
    protected Menu menu;
    protected Home home;
    protected Subs subs;
    protected VideoPage videoPage;
    protected WebDriver driver;

    public void init(){loginpage = new LoginMain();
        menu = new Menu();
        home = new Home();
        subs = new Subs();
        videoPage = new VideoPage();
        driver = DriverManager.getDriverManager().getDriver();
    }
}
