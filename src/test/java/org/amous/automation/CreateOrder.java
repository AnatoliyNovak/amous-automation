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
import java.util.Random;


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
    public final String SELECTCUSTOMER = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div[1]/div[2]/div/div";
    public final String ORDERTYPE = "//*[@id=\"react-select-5--value\"]/div[2]";
    public final String NUMBEROFLOADS = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div[2]/div/div[1]/input";
    public final String SAVEANDDUPLICATE = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div[2]/div/div[2]/button[2]";
    public final String CUSTOMERCONTACTNAME = "//*[@id=\"contactName\"]";
    public final String CUSTOMERCONTACTPHONE = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div[1]/div[2]/div[1]/div/form/div[3]/div/div[5]/div[2]/div[2]/div/div/input";
    public final String CUSTOMERCONTACTEMAIL = "//*[@id=\"email\"]";
    public final String CUSTOMERCOMMENTARS = "//*[@id=\"comments\"]";
    public final String CURRENCY = "//*[@id=\"currency\"]";
    public final String DISPATCHBORD = "//*[@id=\"app-container\"]/div/div/div/div[1]/div/div[3]/div[3]/div[4]";

    public void createOrder(ChromeDriver driver) {

        WebElement createOrder = driver.findElement(By.xpath(CREATE_ORDER_CLICK));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", createOrder);
        WebDriverUtil.wait(driver, SELECTCUSTOMER, Duration.ofSeconds(1000));
        WebElement selectCustomerClick = driver.findElement(By.xpath(SELECTCUSTOMER));
        new Actions(driver).moveToElement(selectCustomerClick)
                .click()
                .sendKeys("Warner Bros\n")
                .perform();
        WebDriverUtil.action(driver, BILLTO);
        WebDriverUtil.waitAndClick(driver, PICKUP_PAGE, Duration.ofSeconds(9999999));
        WebDriverUtil.action(driver, PICKUP);
        driver.findElement(By.xpath(ITEMSID)).sendKeys("AutomationBox");
        driver.findElement(By.xpath(WEIGHT)).sendKeys("1500");
        driver.findElement(By.xpath(QUANTITY)).sendKeys("3");
        WebDriverUtil.select(driver, QOM, 12);
        WebDriverUtil.select(driver, FREIGHTCKASS, 3);
        WebElement drop = driver.findElement(By.xpath(DROP));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", drop);
        WebElement additionalInfo = driver.findElement(By.xpath(ADDITIONALINFO));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", additionalInfo);
        driver.findElement(By.xpath(SPECIALINSTRUCTIONS)).sendKeys("This is my first automation test. Don't judge too hard");
        driver.findElement(By.xpath(REFERENCES)).sendKeys("777");
        WebElement selectOrderType = driver.findElement(By.xpath(ORDERTYPE));
        new Actions(driver).moveToElement(selectOrderType)
                .click()
                .sendKeys("Variant\n" + new Random().nextInt(6))
                .perform();
        WebDriverUtil.pausetest(2000);
        WebDriverUtil.action(driver, PRICEING);
        WebDriverUtil.action(driver, CUSTOMERRATE);
        WebDriverUtil.wait(driver, RATE, Duration.ofSeconds(1000));
        WebDriverUtil.action(driver, RATE);
        driver.findElement(By.xpath(NUMBEROFLOADS)).clear();
        driver.findElement(By.xpath(NUMBEROFLOADS)).sendKeys("2");
        WebDriverUtil.action(driver, SAVEANDDUPLICATE);
        WebDriverUtil.select(driver, CURRENCY, 3);
        driver.findElement(By.xpath(CUSTOMERCONTACTNAME)).sendKeys("Contact Name");
        driver.findElement(By.xpath(CUSTOMERCONTACTPHONE)).sendKeys("3333333333");
        driver.findElement(By.xpath(CUSTOMERCONTACTEMAIL)).sendKeys("ContactName@YEP.com");
        driver.findElement(By.xpath(CUSTOMERCOMMENTARS)).sendKeys("I am waiting for trip pricing");
        WebDriverUtil.action(driver, SUBMIT);
        WebDriverUtil.pausetest(3000);
        WebElement dispatchBord = driver.findElement(By.xpath(DISPATCHBORD));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", dispatchBord);
        Assert.assertTrue(ObjectUtils.isNotEmpty(DISPATCHBORD));
    }

}