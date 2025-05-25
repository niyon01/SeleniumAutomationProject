package com.example.selenium.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.example.selenium.pages.LoginPage;
import com.example.selenium.pages.InventoryPage;

public class RegressionTest {
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
    public void testInventoryItemCount() throws InterruptedException {
      
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");
       
        int productCount = inventoryPage.getProducts().size();
        Assertions.assertEquals(6, productCount, 
                "There should be 6 products displayed on the inventory page.");
      
        Thread.sleep(20000);
    }
}
