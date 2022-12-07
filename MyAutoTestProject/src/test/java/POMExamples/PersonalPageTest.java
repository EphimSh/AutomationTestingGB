package POMExamples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonalPageTest extends AbstractTest{

    @Test
    @DisplayName("Login and quit from user profile page")
    void loginAndQuitFromProfilePage(){
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.closeAnnoyingWindow();
        mainPage.loginInButtonClick();
        mainPage.loginIn("ephimizm@gmail.com", "Gfhjkm123");
        PersonalPage personalPage = new PersonalPage(getWebDriver());
        personalPage.clickOnUserProfileButton();
        personalPage.quitFromUserProfile();
        assertTrue(true);
    }
}
