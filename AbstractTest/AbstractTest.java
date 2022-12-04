package AbstractTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AbstractTest {
    private static WebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.navigate().to("https://primekraft.ru");


        Actions action = new Actions(driver);
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class*='btn_close'")));

        //div[class*='btn_close']
        action.click(driver.findElement(By.cssSelector("div[class*='btn_close']"))).build().perform();

        //Authentication process
        action.click(getDriver().findElement(
                        By.cssSelector("div[class*='controls'] div[class*='small'] a[class*='btn-show-auth']")))
                .build()
                .perform();
        action.click(getDriver().findElement(By.cssSelector("input[class='phone']")))
                .sendKeys(getDriver().findElement(By.cssSelector("input[class='phone']")), "ephimizm@gmail.com")
                .build()
                .perform();
        action.click(getDriver().findElement(By.cssSelector("input[class='password']")))
                .sendKeys(getDriver().findElement(By.cssSelector("input[class='password']")), "Gfhjkm123")
                .build()
                .perform();
        action.click(getDriver().findElement(By.cssSelector("div[class*='cbaup_btn']"))).build().perform();


        WebElement userName = driver.findElement(By.cssSelector("div[class*='controls'] div[class*='small'] a[href*='/personal/']"));

        new WebDriverWait(driver, Duration.ofSeconds(3));
        assertEquals("Ефим Шапошников", userName.getText(), "Ефим Шапошников");
        //Logged in
    }





    @AfterAll
    static void close(){
        driver.quit();
    }

    public static WebDriver getDriver(){return driver;}
}
