package youtube;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Subs extends AbstractPage {

    @FindBy(linkText = "videogamedunkey")
    private WebElement channel;

    public Subs() {
        super();
    }

    public boolean isOpened() {
        return channel.isDisplayed();
    }
}
