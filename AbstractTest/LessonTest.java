package AbstractTest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LessonTest extends AbstractTest {
    Actions action = new Actions(getDriver());
    JavascriptExecutor js = (JavascriptExecutor) getDriver();


    @Test
    @DisplayName("add multi-protein to the shop-cart and then delete all from the shop-cart")
    void addItemsToTheShopCartAndThenDeleteItems() throws InterruptedException {

        // going to the protein catalog
        Thread.sleep(5000L);
        js.executeScript("document.querySelector('div > div:nth-child(7) > div > div:nth-child(2) > a').click()");

        // waiting for the page is loaded
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("protein"));

        // add items to the shop cart
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j < 4; j++) {
                new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='catalog-section'] > div:nth-child(" + i + ") > :nth-child(" + j + ") a[class*='btn-rounded']")));
                action.click(getDriver().findElement(By.cssSelector("div[class='catalog-section'] > div:nth-child(" + i + ") > :nth-child(" + j + ") a[class*='btn-rounded']")))
                        .build()
                        .perform();
            }
        }
        //items added successfully; we are going to personal shop-cart page
        getDriver().navigate().to("https://primekraft.ru/personal/");
        new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.urlContains("/personal/"));
        action.click(getDriver().findElement(By.cssSelector("div[class*='personal-section'] a[href*='cart']"))).build().perform();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("/cart/"));

        //deleting those items that we just added
        for (int i = 1; i < 7; i++) {
            new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody[id*='basket-item-table'] > :nth-child(" + i + ") svg[class*='remove']")));
            action.click(getDriver().findElement(By.cssSelector("tbody[id*='basket-item-table'] > :nth-child(" + i + ") svg[class*='remove']"))).build().perform();
        }
        assertTrue(true);

    }

    @Test
    @DisplayName("add item and use a promo-code")
    void addItemToTheShopCartThenUsePromoCode() throws InterruptedException {

        // going to the protein catalog
        Thread.sleep(5000L);
        js.executeScript("document.querySelector('div > div:nth-child(7) > div > div:nth-child(2) > a').click()");

        // waiting for the page is loaded
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("protein"));

        //add item to the shop-cart
        action.click(getDriver().findElement(By.cssSelector("div[class='catalog-section'] > div:nth-child(1) > :nth-child(1) a[class*='btn-rounded']")))
                .build()
                .perform();


        //item added successfully; we are going to personal shop-cart page
        getDriver().navigate().to("https://primekraft.ru/personal/");
        new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.urlContains("/personal/"));
        action.click(getDriver().findElement(By.cssSelector("div[class*='personal-section'] a[href*='cart']"))).build().perform();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("/cart/"));

        action.sendKeys(getDriver().findElement(By.cssSelector("div[class*='basket-coupon'] input")), "PRIME_PARTNER_11555").build().perform();
        new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div[class*='basket-coupon-alert'] span[class*='coupon-text']"), "купон применен"));
        assertTrue(true);


    }


}
