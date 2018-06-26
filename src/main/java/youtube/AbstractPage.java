package youtube;

import manager.DriverManager;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    AbstractPage() {
        PageFactory.initElements(DriverManager.getDriverManager().getDriver(), this);
    }

    String getTitle() {
        return DriverManager.getDriverManager().getDriver().getTitle();
    }
}