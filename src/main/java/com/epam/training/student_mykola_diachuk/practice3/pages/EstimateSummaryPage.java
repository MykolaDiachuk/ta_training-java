package com.epam.training.student_mykola_diachuk.practice3.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EstimateSummaryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локатори для відповідних полів
    private By numberOfInstancesField = By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[7]/span/span[1]/span[2]");
    private By operatingSystemField = By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[8]/span/span[1]/span[2]");
    private By provisioningModelField = By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[9]/span/span[1]/span[2]");////*[@id="yDmH0d"]/c-wiz[1]/div/div/div/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/span[2]/span[1]/span[2]
    private By machineTypeField = By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/span[2]/span[1]/span[2]");
    private By gpuTypeField = By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[4]/span[2]/span[1]/span[2]");
    private By numberOfGpusField = By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[4]/span[3]/span[1]/span[2]");
    private By localSsdField = By.cssSelector("#yDmH0d > c-wiz.SSPGKf > div > div > div > div > div > div.qBohdf.AlLELb > div.oijjFb > div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(5) > span > span.Z7Pe2d.g5Ano > span.Kfvdz");
    private By regionField = By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[15]/span/span[1]/span[2]");

    // Конструктор класу
    public EstimateSummaryPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Методи для отримання значень полів
    public String getNumberOfInstances() {
      /* JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return document.querySelector(\"#yDmH0d > c-wiz.SSPGKf > div > div > div > div > div > div.qBohdf.AlLELb > div.oijjFb > div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(6) > span > span.Z7Pe2d.g5Ano > span.Kfvdz\").innerText");*/

        return wait.until(ExpectedConditions.visibilityOfElementLocated(numberOfInstancesField)).getText();
    }

    public String getOperatingSystem() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(operatingSystemField)).getText();
    }

    public String getProvisioningModel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(provisioningModelField)).getText();
    }


    public String getMachineType() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(machineTypeField)).getText();
    }

    public String getGpuType() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(gpuTypeField)).getText();
    }

    public String getNumberOfGpus() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(numberOfGpusField)).getText();
    }

    public String getLocalSsd() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(localSsdField)).getText();
    }

    public String getRegion() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(regionField)).getText();
    }
}
