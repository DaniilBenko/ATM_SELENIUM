package constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum Browsers {
    CHROME("webdriver.chrome.driver", "c:\\chromedriver.exe"),
    FIREFOX("webdriver.gecko.driver", "c:\\geckodriver.exe");

    private String path;
    private WebDriver driver;
    private String key;

    Browsers(String key, String path) {
        this.path = path;
        this.key = key;

    }

    public String getPath() {
        return path;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getKey() {
        return key;
    }
}
