package com.epam.training.student_mykola_diachuk.practice2.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PastebinResultPage {
    private WebDriver driver;

    // Constructor
    public PastebinResultPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locate elements
    private By pageTitle = By.tagName("h1");
    private By syntaxLabel = By.xpath("//a[@class=\"btn -small h_800\" and text()=\"Bash\"]");
    private By codeBlock = By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/ol/li/div");

    // Methods to validate the results
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public String getSyntaxLabel() {
        return driver.findElement(syntaxLabel).getAttribute("textContent").trim();
    }

    public String getCode() {

        List<WebElement> codeLines = driver.findElements(By.cssSelector("div.source.bash ol.bash li"));

        StringBuilder codeBuilder = new StringBuilder();


        for (WebElement line : codeLines) {
            codeBuilder.append(line.getText()).append("\n");
        }

        return codeBuilder.toString().trim();
    }
}
