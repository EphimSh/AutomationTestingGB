package org.example.lesson.homework;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AuthPositive {
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

        try{
            driver.findElement(
                    By.cssSelector("div[class*='controls'] div[class*='text'] a[href='/auth/']")).click();
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

//        driver.quit();
    }
}
