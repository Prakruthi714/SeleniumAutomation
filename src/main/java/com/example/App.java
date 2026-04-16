package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class App {

    public static void main(String[] args) {

        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Launch browser
        WebDriver driver = new ChromeDriver();

        try {
            // Open website (login page)
            driver.get("https://automationexercise.com/login");
            driver.manage().window().maximize();

            // Wait object (better than Thread.sleep)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Enter email
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")))
                .sendKeys("test@example.com");

            // Enter password
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")))
                .sendKeys("123456");

            // Click login button
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='Login']")))
                .click();

            // Wait a bit to see result
            Thread.sleep(5000);

            // Print page title
            System.out.println("Page Title: " + driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
