package POMExamples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingTest extends AbstractTest {

    private boolean checkAddedItem(String item, String addedItem) {
        if (Objects.equals(item, addedItem)) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    @DisplayName("Add item to shop cart")
    void addItemToTheShopCart() {
        CatalogList catalogList = new CatalogList(getWebDriver());
        MainPage mainPage = new MainPage(getWebDriver());
        PersonalCartPage personalCart = new PersonalCartPage(getWebDriver());
        mainPage.closeAnnoyingWindow();
        catalogList.clickOnDropDownMenuSaleButton();
        String tempStr = catalogList.itemCardTitleGetText();
        catalogList.clickOnFirstItemAddButton();
        mainPage.headerMenuPersonalCartClick();

        assertTrue(checkAddedItem(personalCart.getAddedItemTitle(), tempStr));
    }


}
