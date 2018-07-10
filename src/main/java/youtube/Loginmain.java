package youtube;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LoginMain extends  AbstractPage{
    @FindBy(xpath = "//*[@id=\"text\"]" )
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"identifierId\"]" )
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"identifierNext\"]/content/span" )
    private WebElement logInNext;

    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input" )
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"passwordNext\"]/content/span" )
    private WebElement passwordNext;

    public LoginMain() {
        super();
    }

    public LoginMain clickSignIn(){
        signInButton.click();
        return new LoginMain();
    }

    public void enterLogin(String login){
        loginField.clear();
        loginField.sendKeys(login);
    }

    public void clickLoginNext(){
        logInNext.click();
    }

    public void enterPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickPasswordNext(){
        passwordNext.click();
    }

    public void doLogin(String login, String password){
        this.clickSignIn();
        this.enterLogin(login);
        this.clickLoginNext();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.enterPassword(password);
        this.clickPasswordNext();

    }
}