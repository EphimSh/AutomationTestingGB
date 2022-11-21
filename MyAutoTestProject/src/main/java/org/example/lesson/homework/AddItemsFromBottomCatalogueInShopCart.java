package org.example.lesson.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddItemsFromBottomCatalogueInShopCart {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://primekraft.ru");

        //Waiting for annoying pop-up appends
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='form_content']")));
        try{
            driver.findElement(By.cssSelector("div[class*='btn_close']")).click();
        } catch (NoSuchElementException e){
            e.getSupportUrl();
        }
        //Annoying pop-up closed

        // Pressing logIn button to call a modal logIn window
        try{
            driver.findElement(By.cssSelector("div[class*='controls'] div[class*='text'] a[href='/auth/']")).click();
        } catch (NoSuchElementException e){
            e.getSupportUrl();
        }

        //LogIn with valid data
        try{
            driver.findElement(By.cssSelector("input[class*='phone']")).sendKeys("ephimizm@gmail.com");
            driver.findElement(By.cssSelector("input[class*='password']")).sendKeys("Gfhjkm123");
            driver.findElement(By.cssSelector("div[class*='cbaup_btn']")).click();
        } catch (NoSuchElementException e){
            e.getSupportUrl();
        }


        new WebDriverWait(driver, Duration.ofSeconds(7)).until(ExpectedConditions.urlContains("/personal/private/"));

//      going to the shop catalog page
        try{
            driver.findElement(By.cssSelector("div[class*='container'] a[href*='/catalog/']")).click();
        } catch (NoSuchElementException e){
            e.getSupportUrl();
        }

        new WebDriverWait(driver, Duration.ofSeconds(7)).until(ExpectedConditions.urlContains("/catalog/"));

//      add an item to the cart from catalog
        try{
            driver.findElement(By.cssSelector("div[class*='catalog-section'] a[class*='btn-rounded']")).click();
        } catch (NoSuchElementException e){
            e.getSupportUrl();
        }

//        Going to the cart page
        try{
            driver.findElement(By.cssSelector("div[class*='controls'] a[class*='cart']")).click();
        } catch (NoSuchElementException e){
            e.getSupportUrl();
        }

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("/personal/cart/"));


//      Add more items from the bottom catalog 
        try{
            driver.findElement(By.cssSelector("div[class*='catalog-section'] > div > div:nth-child(1) a[class*='btn-rounded']")).click();
            driver.findElement(By.cssSelector("div[class*='catalog-section'] > div > div:nth-child(2) a[class*='btn-rounded']")).click();
            driver.findElement(By.cssSelector("div[class*='catalog-section'] > div > div:nth-child(3) a[class*='btn-rounded']")).click();
            driver.findElement(By.cssSelector("div[class*='catalog-section'] > div > div:nth-child(4) a[class*='btn-rounded']")).click();
            driver.findElement(By.cssSelector("div[class*='catalog-section'] > div > div:nth-child(5) a[class*='btn-rounded']")).click();

        } catch (NoSuchElementException e) {
            e.getSupportUrl();
        }


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -700)", "");

        js.executeScript("window.scrollBy(0, 400)", "");



//        driver.quit();
    }


}
