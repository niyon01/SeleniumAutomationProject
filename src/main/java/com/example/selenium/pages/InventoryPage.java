package com.example.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class InventoryPage {
    private WebDriver driver;

    // Locators for elements on the inventory page
    private By pageTitle        = By.className("title");              // Title element (text should be "Products")
    private By productNameItems = By.className("inventory_item_name"); // All product name elements

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    /** 
     * Check if the inventory page is loaded by verifying the title text.
     */
    public boolean isLoaded() {
        String titleText = driver.findElement(pageTitle).getText();
        return titleText.equals("Products");
    }

    /** 
     * Get all product name elements displayed on the inventory page.
     */
    public List<WebElement> getProducts() {
        return driver.findElements(productNameItems);
    }
}
