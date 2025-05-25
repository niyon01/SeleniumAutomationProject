package com.example.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private final String url = "https://www.saucedemo.com/";  // Login page URL

    // Locators for login form elements
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton   = By.id("login-button");
    private By errorMessage  = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /** Open the login page in the browser */
    public void open() {
        driver.get(url);
    }

    /** 
     * Perform login with given credentials.
     * @return InventoryPage object if login is successful.
     */
    public InventoryPage login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        // Return the inventory page (next page) after successful login
        return new InventoryPage(driver);
    }

    /**
     * Get the error message text displayed on login failure.
     * @return Error message text, or empty string if no error is present.
     */
    public String getErrorMessage() {
        try {
            WebElement errorMsg = driver.findElement(errorMessage);
            return errorMsg.getText();
        } catch (Exception e) {
            return "";
        }
    }
}
