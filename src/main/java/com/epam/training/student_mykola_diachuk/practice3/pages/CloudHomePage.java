package com.epam.training.student_mykola_diachuk.practice3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudHomePage {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(@class, 'VVEJ3d') and .//span[text()='Add to estimate']]")
    WebElement addToEstimateButton;

    public CloudHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddToEstimate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement cookieCloseButton = driver.findElement(By.xpath("//*[@id=\"glue-cookie-notification-bar-1\"]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(cookieCloseButton)).click();

        wait.until(ExpectedConditions.elementToBeClickable(addToEstimateButton)).click();
    }


}