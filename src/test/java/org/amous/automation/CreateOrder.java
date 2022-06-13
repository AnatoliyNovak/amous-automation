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

import static org.amous.constant.AmousXpathKeys.CREATE_ORDER.*;

public class CreateOrder {

    public void createOrder(ChromeDriver driver) {
        WebElement createOrder = driver.findElement(By.xpath(CREATE_ORDER_CLICK));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", createOrder);
        WebDriverUtil.wait(driver, SELECT_CUSTOMER, Duration.ofSeconds(1000));
        WebElement selectCustomerClick = driver.findElement(By.xpath(SELECT_CUSTOMER));
        new Actions(driver).moveToElement(selectCustomerClick)
                .click()
                .sendKeys("Warner Bros\n")
                .perform();
        WebDriverUtil.action(driver, BILL_TO);
        WebDriverUtil.waitAndClick(driver, PICKUP_PAGE, Duration.ofSeconds(9999999));
        WebDriverUtil.action(driver, PICKUP);
        driver.findElement(By.xpath(ITEMSID)).sendKeys("AutomationBox");
        driver.findElement(By.xpath(WEIGHT)).sendKeys("1500");
        driver.findElement(By.xpath(QUANTITY)).sendKeys("3");
        WebDriverUtil.select(driver, QOM, 12);
        WebDriverUtil.select(driver, FREIGHT_CLASS, 3);
        WebElement drop = driver.findElement(By.xpath(DROP));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", drop);
        WebElement additionalInfo = driver.findElement(By.xpath(ADDITIONAL_INFO));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", additionalInfo);
        driver.findElement(By.xpath(SPECIAL_INSTRUCTIONS)).sendKeys("This is my first automation test. Don't judge too hard");
        driver.findElement(By.xpath(REFERENCES)).sendKeys("777");
        WebElement selectOrderType = driver.findElement(By.xpath(ORDER_TYPE));
        new Actions(driver).moveToElement(selectOrderType)
                .click()
                .sendKeys("Variant\n")
                .perform();
        WebDriverUtil.pausetest(2000);
        WebDriverUtil.action(driver, PRICEING);
        WebDriverUtil.action(driver, CUSTOMER_RATE);
        WebDriverUtil.wait(driver, RATE, Duration.ofSeconds(1000));
        WebDriverUtil.action(driver, RATE);
        driver.findElement(By.xpath(NUMBER_OF_LOADS)).clear();
        driver.findElement(By.xpath(NUMBER_OF_LOADS)).sendKeys("2");
        WebDriverUtil.action(driver, SAVE_AND_DUPLICATE);
        WebDriverUtil.select(driver, CURRENCY, 3);
        driver.findElement(By.xpath(CUSTOMER_CONTACT_NAME)).sendKeys("Contact Name");
        driver.findElement(By.xpath(CUSTOMER_CONTACT_PHONE)).sendKeys("3333333333");
        driver.findElement(By.xpath(CUSTOMER_CONTACT_EMAIL)).sendKeys("ContactName@YEP.com");
        driver.findElement(By.xpath(CUSTOMER_COMMENTARS)).sendKeys("I am waiting for trip pricing");
        WebDriverUtil.action(driver, SUBMIT);
        WebDriverUtil.pausetest(3000);
        WebElement dispatchBord = driver.findElement(By.xpath(DISPATCH_BOARD));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", dispatchBord);
        Assert.assertTrue(ObjectUtils.isNotEmpty(DISPATCH_BOARD));
    }

}