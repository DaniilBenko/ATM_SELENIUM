package youtube;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menu extends AbstractPage {

    @FindBy(xpath = "//*[@id=\\\"guide-icon\\\"]")
    private WebElement burger;

    @FindBy(linkText = "Home")
    private WebElement homeButton;

    @FindBy(linkText = "Subscriptions")
    private WebElement subsButton;

    public Menu() {
        super();
    }

    public boolean isOpened() {
        return subsButton.isDisplayed();
    }

    public void goToHome (){
        homeButton.click();
    }

    public void goToSubs (){
        subsButton.click();
    }
}
