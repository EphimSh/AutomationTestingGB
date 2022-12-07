package POMExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    private WebDriver webDriver;

    public AbstractPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    protected WebDriver getWebDriver(){return this.webDriver;}
}
