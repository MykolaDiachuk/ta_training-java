package com.epam.training.student_mykola_diachuk.practice3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EstimatePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//div[@data-service-form='8' and @role='button']")
    WebElement computeEngineTab;

    @FindBy(xpath = "//*[@id='c22']")
    WebElement numberOfInstances;

    @FindBy(xpath = "//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[7]/div/div[1]/div/div/div/div[1]")
    WebElement operatingSystemDropdown;

    @FindBy(xpath = "//*[@id=\"107regular\"]")
    WebElement provisioningModelDropdown;

    @FindBy(xpath = "//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[1]/div/div/div/div[1]")
    WebElement machineFamilyDropdown;

    @FindBy(xpath = "//*[@id=\"ow6\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[2]/div/div/div/div[1]")
    WebElement seriesDropdown;

    @FindBy(xpath = "//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[3]/div/div/div/div[1]")
    WebElement machineTypeDropdown;

    @FindBy(xpath = "//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[21]/div/div/div[1]/div/div/span/div/button")
    WebElement addGPUsCheckbox;

    @FindBy(xpath = "//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[23]/div/div[1]/div/div/div/div[1]")
    WebElement gpuTypeDropdown;

    @FindBy(xpath = "//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[24]/div/div[1]/div/div/div/div[1]")
    WebElement numberOfGpusDropdown;

    @FindBy(xpath = "//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[27]/div/div[1]/div/div/div/div[1]")
    WebElement ssdDropdown;

    @FindBy(xpath = "//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[29]/div/div[1]/div/div/div/div[1]")
    WebElement regionDropdown;

    @FindBy(xpath = "//button[@aria-label='Open Share Estimate dialog']")
    WebElement shareButton;

    @FindBy(xpath = "//a[@track-name='open estimate summary']")
    WebElement estimateSummary;


    public EstimatePage(WebDriver driver, WebDriverWait wait ) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void fillForm() {

        clickComputeEngineTab(wait);
        selectNumberOfInstances(wait);
        selectOperatingSystem(wait);
        clickRegular();
        selectMachineFamily(wait);
        selectSeries(wait);
        selectMashineType(wait);
        clickAddGPUs(wait);
        selectGPUType(wait);
        selectNumberOfGPUs(wait);
        selectSSD(wait);
        selectRegion(wait);
    }

    private void clickComputeEngineTab(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(computeEngineTab)).click();
    }
    private void selectNumberOfInstances(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(numberOfInstances)).clear();
        numberOfInstances.sendKeys("4");
    }
    private void selectOperatingSystem(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(operatingSystemDropdown)).click();
        WebElement os = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[7]/div/div[1]/div/div/div/div[2]/ul/li[1]")));
        os.click();
    }
    private void clickRegular() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement regularRadioButton = driver.findElement(By.id("107regular"));
        js.executeScript("arguments[0].click();", regularRadioButton);

    }
    private void selectMachineFamily(WebDriverWait wait) {
        scrollToElement(driver, machineFamilyDropdown);
        wait.until(ExpectedConditions.elementToBeClickable(machineFamilyDropdown)).click();
        WebElement mf = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-value='general-purpose']")));
        mf.click();
    }
    private void selectSeries(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(seriesDropdown)).click();
        WebElement mt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[2]/div/div/div/div[2]/ul/li[1]")));
        mt.click();
    }
    private void selectMashineType(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(machineTypeDropdown)).click();
        WebElement mt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[3]/div/div/div/div[2]/ul/li[7]")));
        mt.click();
    }

    private void clickAddGPUs(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(addGPUsCheckbox)).click();
    }
    private void selectGPUType(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(gpuTypeDropdown)).click();
        WebElement mt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[23]/div/div[1]/div/div/div/div[2]/ul/li[2]")));
        mt.click();
    }
    private void selectNumberOfGPUs(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(numberOfGpusDropdown)).click();
        WebElement mt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[24]/div/div[1]/div/div/div/div[2]/ul/li[1]")));
        mt.click();
    }
    private void selectSSD(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(ssdDropdown)).click();
        WebElement mt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[27]/div/div[1]/div/div/div/div[2]/ul/li[3]")));
        mt.click();
    }
    private void selectRegion(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(regionDropdown)).click();
        WebElement mt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ow6\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[29]/div/div[1]/div/div/div/div[2]/ul/li[5]")));
        mt.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void clickShare() {
        wait.until(ExpectedConditions.elementToBeClickable(shareButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(estimateSummary)).click();

    }



    private void scrollToElement(WebDriver driver, WebElement element) {
        // Використання Actions для фокусування на елементі
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        // Використання JavaScript для прокрутки до елемента і вирівнювання його по центру
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo({top: arguments[0].getBoundingClientRect().top + window.scrollY - (window.innerHeight / 2), behavior: 'smooth'});", element);
    }


}