package POMExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AbstractTest {
    static WebDriver webDriver;

    @BeforeAll
    static void setWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeEach
    void goTo() {
        Assertions.assertDoesNotThrow(() -> getWebDriver().navigate().to("https://primekraft.ru"), "Не удается получить доступ к сайту");
        assertTrue(true);
    }

    @AfterAll
    static void close() {
//        webDriver.quit();
    }


    public WebDriver getWebDriver() {
        return webDriver;
    }
}
