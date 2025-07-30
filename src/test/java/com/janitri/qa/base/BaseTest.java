package com.janitri.qa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Sets up the Chrome driver automatically
        WebDriverManager.chromedriver().setup();
        // Initializes the WebDriver
        driver = new ChromeDriver();
        // Maximizes the browser window
        driver.manage().window().maximize();
        // Sets an implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigates to the test page URL
        driver.get("https://dev-dash.janitri.in/"); // [cite: 6]
    }

    @AfterMethod
    public void tearDown() {
        // Closes the browser after each test method
        if (driver != null) {
            driver.quit();
        }
    }
}