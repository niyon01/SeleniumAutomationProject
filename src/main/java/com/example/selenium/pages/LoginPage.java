package com.example.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private final String url = "https://www.saucedemo.com/";  
   
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton   = By.id("login-button");
    private By errorMessage  = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

 
    public void open() {
        driver.get(url);
    }

  
    public InventoryPage login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
     
        return new InventoryPage(driver);
    }

   
    public String getErrorMessage() {
        try {
            WebElement errorMsg = driver.findElement(errorMessage);
            return errorMsg.getText();
        } catch (Exception e) {
            return "";
        }
    }
}
