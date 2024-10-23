package com.epam.training.student_mykola_diachuk.practise3.tests;

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


        Assertions.assertEquals("4", summaryPage.getNumberOfInstances());
        Assertions.assertEquals("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)", summaryPage.getOperatingSystem());
        Assertions.assertEquals("Regular", summaryPage.getProvisioningModel());
        Assertions.assertEquals("n1-standard-8, vCPUs: 8, RAM: 30 GB", summaryPage.getMachineType());
        Assertions.assertEquals("NVIDIA V100", summaryPage.getGpuType());
        Assertions.assertEquals("1", summaryPage.getNumberOfGpus());
        Assertions.assertEquals("2x375 GB", summaryPage.getLocalSsd());
        Assertions.assertEquals("Netherlands (europe-west4)", summaryPage.getRegion());


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