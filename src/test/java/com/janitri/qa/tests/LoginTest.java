package com.janitri.qa.tests;

import com.janitri.qa.base.BaseTest;
import com.janitri.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Validate presence of page elements on load")
    public void testPageElementsPresence() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.arePageElementsVisible(), "User ID or Password fields are not visible.");
    }

    @Test(priority = 2, description = "Test login button is enabled")
    public void testLoginButtonIsEnabled() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginButtonEnabled(), "Login button should be enabled.");
    }

    @Test(priority = 3, description = "Test invalid login does not navigate away")
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        String urlBeforeLogin = driver.getCurrentUrl();

        loginPage.enterUserId("randomuser@gmail.com");
        loginPage.enterPassword("randompassword");
        loginPage.clickLoginButton();

        loginPage.tryToGetAndPrintError();

        String urlAfterLogin = driver.getCurrentUrl();
        Assert.assertEquals(urlAfterLogin, urlBeforeLogin, "URL should not change after a failed login attempt.");
    }

    @Test(priority = 4, description = "Test password field is masked by default")
    public void testPasswordMaskingToggle() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterPassword("somepassword");

        Assert.assertEquals(loginPage.getPasswordInputType(), "password", "Password is not masked by default.");

    }
}