package POMExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainMenu extends AbstractPage {
    @FindBy(css = "div[id*='mainMenu']")
    private List<WebElement> mainMenu;

    @FindBy(css = "div[id*='mainMenu'] a[href*='catalog']")
    private WebElement mainMenuCatalogBtn;

    @FindBy(css = "div[id*='mainMenu'] a[href*='sale-promotions']")
    private WebElement mainMenuSalePromoBtn;

    @FindBy(css = "div[id*='mainMenu'] a[href*='delivery']")
    private WebElement mainMenuDeliveryBtn;

    @FindBy(css = "div[id*='mainMenu'] a[href*='telegram']")
    private WebElement mainMenuGetAGiftBtn;

    @FindBy(css = "div[id*='mainMenu'] a[href*='partners']")
    private WebElement mainMenuBecomePartnerBtn;

    @FindBy(css = "div[id*='mainMenu'] a[href*='personal/order/spy']")
    private WebElement mainMenuOrderTrackBtn;

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    public void clickOnCatalogButton() {
        Actions action = new Actions(getWebDriver());
        action.click(mainMenuCatalogBtn).build().perform();
    }

    public void clickOnSalePromotionButton() {
        Actions action = new Actions(getWebDriver());
        action.click(mainMenuSalePromoBtn).build().perform();
    }

    public void clickOnDeliveryButton() {
        Actions action = new Actions(getWebDriver());
        action.click(mainMenuDeliveryBtn).build().perform();
    }

    public void clickOnGetGiftButton() {
        Actions action = new Actions(getWebDriver());
        action.click(mainMenuGetAGiftBtn).build().perform();
    }

    public void clickOnBecomePartnerButton() {
        Actions action = new Actions(getWebDriver());
        action.click(mainMenuBecomePartnerBtn).build().perform();
    }

    public void clickOnOrderTrackButton() {
        Actions action = new Actions(getWebDriver());
        action.click(mainMenuOrderTrackBtn).build().perform();
    }

}
