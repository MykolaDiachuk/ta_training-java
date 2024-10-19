package com.epam.training.student_mykola_diachuk.practice1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomePage {
    private WebDriver driver;

    private By pasteTextArea = By.id("postform-text");
    private By pasteExperationDropdown = By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[4]/div/span/span[1]/span");
    private By pasteNameField  = By.id("postform-name");
    private By createPasteButton  = By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[10]/button");

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterCode(String code) {
        WebElement textArea = driver.findElement(pasteTextArea);
        textArea.sendKeys(code);
    }
    public void selectPasteExpiration(String expiration) {
        WebElement select2Container = driver.findElement(pasteExperationDropdown);
        select2Container.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-postform-expiration-results")));
        WebElement optionToSelect = driver.findElement(By.xpath("//li[contains(text(),'" + expiration + "')]"));
        optionToSelect.click();

    }
    public void enterPasteName(String name) {
        WebElement nameField = driver.findElement(pasteNameField);
        nameField.sendKeys(name);
    }
    public void clickCreatePaste() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement createPasteButton = wait.until(ExpectedConditions.elementToBeClickable(this.createPasteButton));
        createPasteButton.click();
    }


}
