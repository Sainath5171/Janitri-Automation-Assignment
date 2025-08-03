package com.janitri.qa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Create a map to disable notification popups
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);

        // Create a ChromeOptions object and set the preference
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        // Sets up the Chrome driver automatically
        WebDriverManager.chromedriver().setup();

        // Initializes the WebDriver with the new options
        driver = new ChromeDriver(options);

        // Maximizes the browser window
        driver.manage().window().maximize();
        // Sets an implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigates to the test page URL
        driver.get("https://dev-dash.janitri.in/");
    }

    @AfterMethod
    public void tearDown() {
        // Closes the browser after each test method
        if (driver != null) {
            driver.quit();
        }
    }
}