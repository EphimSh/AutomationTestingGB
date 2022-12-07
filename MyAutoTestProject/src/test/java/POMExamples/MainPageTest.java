package POMExamples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest extends AbstractTest {

    @Test
    void closeAnnoyingWindowTest(){
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.closeAnnoyingWindow();
        assertTrue(true);
    }

    @Test
    void loggingIntoPersonalPage(){
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.closeAnnoyingWindow();
        mainPage.loginInButtonClick();
        mainPage.loginIn("ephimizm@gmail.com", "Gfhjkm123");
        assertTrue(true);
    }
}
