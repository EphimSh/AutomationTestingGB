package POMExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PersonalPage extends AbstractPage {

    @FindBy(css = "div[class*='controls'] div[class*='small'] a[href*='/personal/']")
    private WebElement userProfileBtn; //Click on this button leads to the personal page

    @FindBy(css = "div[class*='personal-section'] a[href*='cart']")
    private WebElement userShopCartBtn;

    @FindBy(css = "div[class*='personal-section'] a[href*='logout']")
    private WebElement logoutBtn;

    public void goToUserShopCart(){
        Actions action = new Actions(getWebDriver());
        action.click(userShopCartBtn).build().perform();
    }

    public void clickOnUserProfileButton(){
        Actions action = new Actions(getWebDriver());
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(userProfileBtn));
        action.click(userProfileBtn).build().perform();
    }

    public void quitFromUserProfile(){
        Actions action = new Actions(getWebDriver());
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(logoutBtn));
        action.click(this.logoutBtn).build().perform();
    }
    
    public PersonalPage(WebDriver driver){super(driver);}

}
