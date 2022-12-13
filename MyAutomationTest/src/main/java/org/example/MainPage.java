package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends AbstractPage{
    @FindBy(css = "div[class*='controls'] div[class*='small'] a[href*='/auth/']")
    private WebElement authBtn;

    @FindBy(css = "div[class*='fancybox-content'] input[class*='phone']")
    private WebElement login;

    @FindBy(css = "div[class*='fancybox-content'] input[class*='password']")
    private WebElement password;

    @FindBy(css = "div[class*='fancybox-content'] div[class*='cbaup_btn']")
    private WebElement submitBtn;

    @FindBy(css= "div[class*='btn_close']")
    private WebElement annoyingWindowCloseButton;

    public WebElement getAnnoyingWindowCloseButton() {
        return annoyingWindowCloseButton;
    }

    public void loginInPressButton() {
        this.authBtn.click();
    }

    public MainPage setLogin(String login) {
        this.login.click();
        this.login.sendKeys(login);
        return this;
    }

    public MainPage setPassword(String password) {
        this.password.click();
        this.password.sendKeys(password);
        return this;
    }

    public void loginIn(String email, String pswrd) {
        Actions action = new Actions(getWebDriver());
        action.click(this.login).sendKeys(this.login, email).build().perform();
        action.click(this.password).sendKeys(this.password, pswrd).build().perform();

    }

    public void closeAnnoyingWindow(){
        Actions closeWindow = new Actions(getWebDriver());
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(annoyingWindowCloseButton));
        closeWindow.click(annoyingWindowCloseButton).build().perform();
    }
    public MainPage(WebDriver webDriver){
        super(webDriver);
    }
}
