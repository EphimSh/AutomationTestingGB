import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.MyWebDriverListener;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AbstractTest {

    static EventFiringWebDriver webDriver;
    @BeforeAll
    static void setWebDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        webDriver = new EventFiringWebDriver(new ChromeDriver(options));
        webDriver.register(new MyWebDriverListener());
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow(() -> getWebDriver().navigate().to("https://primekraft.ru"), "Не удается получить доступ к сайту");
        assertTrue(true);
    }

    @AfterAll
    static void close(){
        if(webDriver != null) webDriver.quit();
//        webDriver.quit();
    }

    @AfterEach
    public void checkBrowser(){
        List<LogEntry> allLogRows = getWebDriver().manage().logs().get(LogType.BROWSER).getAll();
        if(!allLogRows.isEmpty()){
            if(allLogRows.size() > 0){
                allLogRows.forEach(logEntry -> {
                    System.out.println(logEntry.getMessage());
                });
            }
        }
    }
    public WebDriver getWebDriver(){
        return webDriver;
    }
}
