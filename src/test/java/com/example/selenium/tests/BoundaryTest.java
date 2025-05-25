package com.example.selenium.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.example.selenium.pages.LoginPage;

public class BoundaryTest {
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
    public void testInvalidLogin() throws InterruptedException {
      
        loginPage.open();
        loginPage.login("standard_user", "wrong_password");
       
        String errorMsg = loginPage.getErrorMessage();
        Assertions.assertTrue(errorMsg.contains("Username and password do not match"),
                "Error message should indicate invalid login credentials.");
     
        Thread.sleep(20000);
    }
}
