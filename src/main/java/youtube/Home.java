package youtube;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

public class Home extends AbstractPage {
    @FindBy(css = "#dismissable > ytd-thumbnail" )
    private WebElement firstVideo;

    public Home() {
        super();
    }

    public void openVideo(){
        firstVideo.click();
    }

    public boolean isOpened() {
        return firstVideo.isDisplayed();
    }
}
