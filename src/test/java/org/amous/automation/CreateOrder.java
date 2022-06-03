package org.amous.automation;

import org.amous.utils.WebDriverUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CreateOrder {
    public final String CREATE_ORDER_CLICK = "/html/body/div/div/div/div/div/div[1]/div/div[1]/div[1]/div[3]/div";
    public final String PICKUP = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div[1]/div[2]/div[1]/form/div[1]/div[1]/div[2]";
    public final String PICKUP_PAGE = "//*[@id=\"app-container\"]/div/div/div/div[2]/div";
    public final String ITEMSID = "//*[@id=\"items.0.itemId\"]";
    public final String WEIGHT = "//*[@id=\"items.0.weight\"]";
    public final String QUANTITY = "//*[@id=\"items.0.quantity\"]";
    public final String QOM = "//*[@id=\"items.0.packageType\"]";
    public final String FREIGHTCKASS = "//*[@id='items.0.freightClass']";
    public final String DROP = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div[1]/div[2]/div[1]/form/div[1]/div[1]/div[3]";
    public final String BILLTO = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div[1]/div[2]/div[1]/form/div[1]/div[1]/div[1]";
    public final String ADDITIONALINFO = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div[1]/div[2]/div[1]/form/div[1]/div[1]/div[4]";
    public final String SPECIALINSTRUCTIONS = "//*[@id=\"specialInstructions\"]";
    public final String REFERENCES = "//*[@id=\"references.0.value\"]";
    public final String PRICEING = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div[1]/div[2]/div[1]/form/div[1]/div[1]/div[5]";
    public final String CUSTOMERRATE = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div[1]/div[2]/div[1]/div/form/div[2]/div[2]/div[1]";
    public final String RATE = "//*[@id=\"app-container\"]/div/div/div/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div[1]/div/div/div/div/input";
    public final String SUBMIT = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div[2]/div/div[2]/button[3]";
    public final String ORDER = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div/div[2]/div[5]/div/div/div/div[2]/div[3]/div/div/div";
    public final String SELECTCUSTOMER = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div[1]/div[2]/div/div";

    public void createOrder(ChromeDriver driver) {

        WebElement createOrder = driver.findElement(By.xpath(CREATE_ORDER_CLICK));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", createOrder);

        WebDriverUtil.wait(driver, SELECTCUSTOMER, Duration.ofSeconds(1000));
        WebElement clickable = driver.findElement(By.xpath(SELECTCUSTOMER));
        new Actions(driver).moveToElement(clickable)
                .click()
                .sendKeys("Warner Bros\n")
                .perform();

        WebElement billTo = driver.findElement(By.xpath(BILLTO));
        WebDriverUtil.action(driver, BILLTO);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", billTo);
        WebDriverUtil.waitAndClick(driver, PICKUP_PAGE, Duration.ofSeconds(9999999));


        WebElement pickup = driver.findElement(By.xpath(PICKUP));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", pickup);
        WebDriverUtil.waitAndClick(driver, PICKUP_PAGE, Duration.ofSeconds(9999999));

        driver.findElement(By.xpath(ITEMSID)).sendKeys("AutomationBox");
        driver.findElement(By.xpath(WEIGHT)).sendKeys("1000");
        driver.findElement(By.xpath(QUANTITY)).sendKeys("3");
        WebDriverUtil.select(driver, QOM, 3);
        WebDriverUtil.select(driver, FREIGHTCKASS, 3);

        WebElement drop = driver.findElement(By.xpath(DROP));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", drop);

        WebElement additionalInfo = driver.findElement(By.xpath(ADDITIONALINFO));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", additionalInfo);

        driver.findElement(By.xpath(SPECIALINSTRUCTIONS)).sendKeys("This is my first automation test. Don't judge too hard");
        driver.findElement(By.xpath(REFERENCES)).sendKeys("777");

        WebElement pricing = driver.findElement(By.xpath(PRICEING));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", pricing);

        WebElement customerRate = driver.findElement(By.xpath(CUSTOMERRATE));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", customerRate);

        WebDriverUtil.wait(driver, RATE, Duration.ofSeconds(1000));
        WebDriverUtil.action(driver, RATE);

        WebElement btnSubmit = driver.findElement(By.xpath(SUBMIT));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", btnSubmit);
        WebDriverUtil.wait(driver, ORDER, Duration.ofSeconds(9999999));

        Assert.assertTrue(ObjectUtils.isNotEmpty(btnSubmit));
    }

}