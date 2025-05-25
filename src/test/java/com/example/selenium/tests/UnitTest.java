package com.example.selenium.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.example.selenium.pages.LoginPage;
import com.example.selenium.pages.InventoryPage;

public class UnitTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeAll
    public static void setupDriverManager() {
        
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
       
        driver = new ChromeDriver();
        driver.manage().window().maximize();
     
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
     
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
     
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginSuccess() throws InterruptedException {
        // Open the login page and perform a valid login
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");
        // Verify that the inventory page loaded successfully
        Assertions.assertTrue(inventoryPage.isLoaded(), 
                "Inventory page should be loaded after a successful login.");
        // Pause for 60 seconds (demo purposes)
        Thread.sleep(20000);
    }
}
