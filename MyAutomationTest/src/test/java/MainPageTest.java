import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.example.Main;
import org.example.MainPage;
import org.example.MyUtils;
import org.example.MyWebDriverListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest extends AbstractTest {



    @Test
    @DisplayName("close annoying window")
    @Description("try to close annoying window")
    @Link("https://primekraft.ru")

    void closeAnnoyingWindowTest(){
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.closeAnnoyingWindow();
        assertTrue(true);
    }

    @Test
    @DisplayName("authentication test")
    @Description("try to logging into the user profile")
    @Link("https://primekraft.ru")

    void loggingInTest(){
        MainPage mainPage = new MainPage(getWebDriver());
        MyWebDriverListener browserListener = new MyWebDriverListener();
        browserListener.beforeClickOn(getWebDriver().findElement(By.cssSelector("div[class*='btn_close']")), getWebDriver());
        try{
            mainPage.loginInPressButton();
            MyUtils.makeScreenshot(getWebDriver(), "success - org.example.MainPageTest" + System.currentTimeMillis() + ".png");
            mainPage.loginIn("ephimizm@gmail.com", "Gfhjkm123");

        } catch (NoSuchElementException e){
            MyUtils.makeScreenshot(getWebDriver(), "failure - org.example.MainPageTest" + System.currentTimeMillis() + ".png");
            e.printStackTrace();
        }

    }

}
