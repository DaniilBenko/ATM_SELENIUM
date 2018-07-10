package youtube;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VideoPage extends AbstractPage {

    @FindBy(css = "#movie_player > div.ytp-chrome-bottom > div.ytp-chrome-controls > div.ytp-left-controls > button")
    private WebElement playButton;

    @FindBy(xpath = "//*[@id=\"movie_player\"]")
    private WebElement player;

    @FindBy(css = ".ytp-fullscreen-button")
    private WebElement expandButton;

    @FindBy(css = ".ytp-mute-button")
    private WebElement soundOnButton;

    @FindBy(className = "ytp-svg-fill ytp-svg-volume-animation-speaker")
    private WebElement soundOffButton;

    @FindBy(linkText = "Home")
    private WebElement homeButton;

    public VideoPage() {
        super();
    }

    public boolean isOpened() {
        return player.isDisplayed();
    }

    public void doFullScreen() {
        expandButton.click();
    }

    public boolean isFullScreenEnabled() {
        return !(homeButton.isDisplayed());
    }

    public void muteVideo() {
        soundOnButton.click();
    }

    public boolean isVideoMuted() {
        return soundOffButton.isDisplayed();
    }


}
