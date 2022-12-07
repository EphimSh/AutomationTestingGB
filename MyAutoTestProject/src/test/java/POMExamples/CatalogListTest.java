package POMExamples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogListTest extends AbstractTest{

    @Test
    @DisplayName("Click on dropDownMenu Element: /catalog/sales/")
    void clickOnDropDownMenuElement(){
        CatalogList dropDownMenu = new CatalogList(getWebDriver());
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.closeAnnoyingWindow();
        dropDownMenu.clickOnDropDownMenuSaleButton();
        assertTrue(true);
    }
}
