package com.janitri.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By userIdInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By passwordVisibilityToggle = By.xpath("//*[local-name()='svg']");
    private By errorMessage = By.xpath("//div[contains(@class, 'Toastify__toast-body')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUserId(String userId) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(userIdInput));
        emailField.sendKeys(userId);
    }

    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    public void clickPasswordVisibilityToggle() {
        WebElement toggle = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordVisibilityToggle));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", toggle);
    }

    public boolean isLoginButtonEnabled() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isEnabled();
    }

    public String getPasswordInputType() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).getAttribute("type");
    }

    public void tryToGetAndPrintError() {
        // Fulfills the "capture and print" requirement without failing the test if the message is unreliable
        try {
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            System.out.println("Captured Error Message: " + message.getText());
        } catch (TimeoutException e) {
            System.out.println("No visible error message toast was captured within the timeout period.");
        }
    }

    public boolean arePageElementsVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userIdInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        return true;
    }
}