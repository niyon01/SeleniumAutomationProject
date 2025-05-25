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
        // Set up ChromeDriver (for Chrome v136) using WebDriverManager
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        // Initialize Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Implicit wait for element lookup (10 seconds)
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        // Instantiate the page object
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        // Close browser after each test
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
