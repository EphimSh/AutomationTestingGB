import io.qameta.allure.Description;
import org.example.MainPage;
import org.example.MyUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EventListenerTest extends AbstractTest{


    @Test
    @DisplayName("click on logIn button")
    @Description("try to click on logIn button")
    void clickOnAuthButtonTest(){
        try{
            MainPage mainPage = new MainPage(getWebDriver());
            mainPage.loginInPressButton();
            new WebDriverWait(getWebDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class*='cbaup_btn']")));
            MyUtils.makeScreenshot(getWebDriver(), "success - org.example.EventListener.test" + System.currentTimeMillis() + ".png");

        } catch (NoSuchElementException e ){
            MyUtils.makeScreenshot(getWebDriver(),
                    "failure - org.example.EventListenerTest.test" + System.currentTimeMillis() + ".png");
        }
    }

    @Test
    @DisplayName("click on header logo button")
    @Description("try to click on main page link aka header-logo button")
    void clickOnHeaderLogoButton(){
        WebElement webElement = getWebDriver().findElement(By.cssSelector("div a.b-header-logo"));
        webElement.click();
    }
}
