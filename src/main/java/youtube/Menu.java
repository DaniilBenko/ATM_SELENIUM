package youtube;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menu extends AbstractPage {

    @FindBy(linkText = "Home")
    private WebElement homeButton;

    @FindBy(linkText = "Subscriptions")
    private WebElement subsButton;

    @FindBy(xpath = "//*[@id=\"items\"]/ytd-guide-entry-renderer[1]")
    private WebElement settings;

    @FindBy(xpath = "//*[@id=\"items\"]/ytd-guide-entry-renderer[3]")
    private WebElement help;

    @FindBy(xpath = "//*[@id=\"items\"]/ytd-guide-entry-renderer[4]")
    private WebElement feedback;

    @FindBy(css = "#creator-sidebar-section-id-account > ul > li.creator-sidebar-item.selected > a")
    private WebElement account;

    @FindBy(xpath = "//*[@id=\"search-box\"]")
    private WebElement searchHelp;

    @FindBy(xpath = "/html/body/div[2]/div/div/uf-describe-page/form/label/textarea")
    private WebElement feedbackTextField;

    public Menu() {
        super();
    }

    public boolean isOpened() {
        return subsButton.isDisplayed();
    }

    public void goToHome() {
        homeButton.click();
    }

    public void goToSubs() {
        subsButton.click();
    }

    public void goToSettings() {
        settings.click();
    }

    public boolean isSettingsOpened() {
        return account.isDisplayed();
    }

    public void goToHelp() {
        help.click();
    }

    public boolean isHelpOpened() {
        return searchHelp.isDisplayed();
    }

    public void goToFeedback() {
        feedback.click();
    }

    public boolean isFeedbackOpened() {
        return feedbackTextField.isDisplayed();
    }
}
