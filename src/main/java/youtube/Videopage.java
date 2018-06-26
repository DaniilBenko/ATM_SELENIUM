package youtube;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Videopage extends AbstractPage {

    @FindBy(css = "#movie_player > div.ytp-chrome-bottom > div.ytp-chrome-controls > div.ytp-left-controls > button" )
    private WebElement playButton;

    @FindBy (xpath = "//*[@id=\"movie_player\"]")
    private WebElement player;

    public Videopage() {
        super();
    }

    public boolean isOpened() {
        return player.isDisplayed();
    }
}
