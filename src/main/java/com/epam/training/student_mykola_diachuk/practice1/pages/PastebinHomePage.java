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
    private By pasteExperationDropdown = By.id("postform-expiration");
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pasteExperationDropdown));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(expiration);
    }
    public void enterPasteName(String name) {
        WebElement nameField = driver.findElement(pasteNameField);
        nameField.sendKeys(name);
    }
    public void clickCreatePaste() {
        WebElement createPasteButton = driver.findElement(this.createPasteButton);
        createPasteButton.click();
    }


}
