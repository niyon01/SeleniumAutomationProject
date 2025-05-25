package com.example.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class InventoryPage {
    private WebDriver driver;


    private By pageTitle        = By.className("title");             
    private By productNameItems = By.className("inventory_item_name"); 

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

   
    public boolean isLoaded() {
        String titleText = driver.findElement(pageTitle).getText();
        return titleText.equals("Products");
    }


    public List<WebElement> getProducts() {
        return driver.findElements(productNameItems);
    }
}
