package com.epam.training.student_mykola_diachuk.practice3.tests;

import com.epam.training.student_mykola_diachuk.practice3.pages.CloudHomePage;
import com.epam.training.student_mykola_diachuk.practice3.pages.EstimatePage;
import com.epam.training.student_mykola_diachuk.practice3.pages.EstimateSummaryPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;


import java.time.Duration;


public class CloudGoogleTest {
    WebDriver driver;
    CloudHomePage cloudHomePage;
    EstimatePage estimatePage;
    EstimateSummaryPage summaryPage;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cloud.google.com/products/calculator");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        cloudHomePage = new CloudHomePage(driver);
        estimatePage = new EstimatePage(driver, wait);
        summaryPage = new EstimateSummaryPage(driver, wait);
    }


    @Test
    public void testAddEstimate() {
        cloudHomePage.clickAddToEstimate();

        estimatePage.fillForm();
        estimatePage.clickShare();

        switchToNewTab();
       /* try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(summaryPage.getNumberOfInstances(), "4");
        softAssert.assertEquals(summaryPage.getOperatingSystem(), "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)");
        softAssert.assertEquals(summaryPage.getProvisioningModel(), "Regular");
        softAssert.assertEquals(summaryPage.getMachineType(), "n1-standard-8, vCPUs: 8, RAM: 30 GB");
        softAssert.assertEquals(summaryPage.getGpuType(), "NVIDIA V100");
        softAssert.assertEquals(summaryPage.getNumberOfGpus(), "1");
        softAssert.assertEquals(summaryPage.getLocalSsd(), "2x375 GB");
        softAssert.assertEquals(summaryPage.getRegion(), "Netherlands (europe-west4)");
        softAssert.assertAll();

    }

    private void switchToNewTab() {
        // Отримати всі вкладки
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}