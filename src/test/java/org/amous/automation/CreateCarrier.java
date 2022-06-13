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

import static org.amous.constant.AmousXpathKeys.CREATE_CARRIER.*;
import static org.amous.constant.AmousXpathKeys.CREATE_ORDER.SELECT_CUSTOMER;
import static org.amous.constant.AmousXpathKeys.CREATE_TRUCK.UPDATE;

public class CreateCarrier {

    public void createCarrier(ChromeDriver driver) {
        WebElement fleetCarrierPage = driver.findElement(By.xpath(CARRIER_PAGE));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", fleetCarrierPage);
        WebDriverUtil.pausetest(3000);
        WebElement treeDots = driver.findElement(By.xpath(TREE_DOTS));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", treeDots);
        WebElement createNewTruck = driver.findElement(By.xpath(CREATE_NEW_CARRIER));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", createNewTruck);
        WebDriverUtil.pausetest(2000);
        driver.findElement(By.xpath(CARRIER_NAME)).sendKeys("Amous"+ new Random().nextInt(999999));
        driver.findElement(By.xpath(USDOT_NUMBER)).sendKeys("A" + new Random().nextInt(999999999));
        driver.findElement(By.xpath(MC_NUMBER)).sendKeys("A" + new Random().nextInt(9999999));
        WebDriverUtil.action(driver, SUBMIT);
        WebDriverUtil.wait(driver, CARRIER_INFO_PAGE, Duration.ofSeconds(10000));
//        WebDriverUtil.select(driver,TRANSPORTATION_MODE,3);
//        WebElement transportationMode = driver.findElement(By.xpath(TRANSPORTATION_MODE));
//        new Actions(driver).moveToElement(transportationMode)
//                .click()
//                .sendKeys("LTL\n")
//                .perform();
        driver.findElement(By.xpath(EMAILS)).sendKeys("emaol" + new Random().nextInt(999999) + "@gmail.com"+"\n","emaol" + new Random().nextInt(999999) + "@gmail.com"+ "\n");
        driver.findElement(By.xpath(PHONE_NUMBER)).sendKeys("456" + new Random().nextInt(9999999));
        WebDriverUtil.pausetest(3000);
        WebDriverUtil.action(driver, SAVE);
        WebDriverUtil.pausetest(4000);
        WebElement dispatchBord = driver.findElement(By.xpath(DISPATCH_BORD));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", dispatchBord);
        Assert.assertTrue(ObjectUtils.isNotEmpty(DISPATCH_BORD));
    }
}

