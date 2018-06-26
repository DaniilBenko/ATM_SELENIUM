import manager.DriverManager;
import org.openqa.selenium.WebDriver;
import youtube.*;

public abstract class AbstractTest {
    protected final String main_url = "https://youtube.com/";
    protected Loginmain loginpage = new Loginmain();
    protected Menu menu = new Menu();
    protected Home home = new Home();
    protected Subs subs = new Subs();
    protected Videopage videopage = new Videopage();
    protected WebDriver driver = DriverManager.getDriverManager().getDriver();
}
