package com.epam.training.student_mykola_diachuk.prictice1.tests;


import com.epam.training.student_mykola_diachuk.practice1.pages.PastebinHomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PastebinTest {
    private WebDriver driver;
    private PastebinHomePage homePage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pastebin.com/");
        homePage = new PastebinHomePage(driver);
    }

    @Test
    public void createPasteTest() {
        homePage.enterCode("Hello from WebDriver");
        homePage.selectPasteExpiration("10 Minutes");
        homePage.enterPasteName("helloweb");
        homePage.clickCreatePaste();

        assertTrue(driver.getTitle().contains("helloweb"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
