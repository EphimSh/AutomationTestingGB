package POMExamples;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatalogList extends AbstractPage {

    //Strings for JavaScriptExecutor
    private String dropDownMenuSaleBtn = "#mainMenu_LkGdQn .mmenu-type1-item__dropdown a[href*=\"/catalog/sale/\"]";

    //JavaScript
    private final String documentQuerySelector = "document.querySelector";
    private final String jsClick = ".click()";

    //WebElements found by
    @FindBy(css = "div[class*='catalog-section'] > :nth-child(1) div[class*='item'] a[class*='btn-rounded']")
    private WebElement firstItemAddButtonInEachCatalogSection;

    @FindBy(css = "div[class*='catalog-section'] article > div[class*='content'] a[title]")
    private WebElement itemCardTitle;

    //Strings for multiple add
    private String catalogSection = "div[class*='catalog-section'] >";
    private String childElement = " :nth-child";
    private String itemAddButton = "div[class*='item'] a[class*='btn-rounded']";

    public CatalogList(WebDriver driver) {
        super(driver);
    }

    public String itemCardTitleGetText(){
        return this.itemCardTitle.getText();
    }

    public void clickOnDropDownMenuSaleButton() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript(documentQuerySelector + "('" + dropDownMenuSaleBtn + "')" + jsClick);
    }

    public void clickOnFirstItemAddButton() {
        Actions action = new Actions(getWebDriver());
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(firstItemAddButtonInEachCatalogSection));
        action.click(firstItemAddButtonInEachCatalogSection).build().perform();
    }

    public void addAllItemsFromFirstItemRow() {
        Actions action = new Actions(getWebDriver());
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(firstItemAddButtonInEachCatalogSection));
        for (int i = 1; i < 4; i++) {
            action.click(getWebDriver()
                    .findElement(By.cssSelector(
                            catalogSection + childElement + "(" + 1 + ") >" + childElement + "(" + i + ")" + itemAddButton))).build().perform();
        }
    }
}
