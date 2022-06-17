package org.amous.automation;

import org.amous.constant.AmousXpathKeys;
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

import static org.amous.constant.AmousXpathKeys.CREATE_DRIVER.*;

public class CreateDriver {

    public void createDriver(ChromeDriver driver) {
        WebElement fleetDriverPage = driver.findElement(By.xpath(AmousXpathKeys.CREATE_DRIVER.FLEET_DRIVER_PAGE));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", fleetDriverPage);
        WebDriverUtil.wait(driver, TREE_DOTS, Duration.ofSeconds(1000));
        WebElement treeDots = driver.findElement(By.xpath(TREE_DOTS));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", treeDots);
        WebElement addDriver = driver.findElement(By.xpath(ADD_DRIVER));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", addDriver);
        WebDriverUtil.action(driver, ADD_NEW_DRIVER);
        driver.findElement(By.xpath(FIRST_NAME)).sendKeys("Driver" + new Random().nextInt(9999));
        driver.findElement(By.xpath(LAST_NAME)).sendKeys("Automation" + new Random().nextInt(9999));
        driver.findElement(By.xpath(LOGIN_ID)).sendKeys("LoginId" + new Random().nextInt(9999));
        driver.findElement(By.xpath(PASSWORD)).sendKeys("1234");
        driver.findElement(By.xpath(EMAIL)).sendKeys("emaol" + new Random().nextInt(9999) + "@gmail.com");
        WebElement selectCustomerClick = driver.findElement(By.xpath(SELECT_PERMISSIONS));
        new Actions(driver).moveToElement(selectCustomerClick)
                .click()
                .sendKeys("Driver\n")
                .perform();
        WebDriverUtil.pausetest(1000);
        WebDriverUtil.action(driver, SUBMIT);
        WebDriverUtil.action(driver, DRIVER_TYPE);
        WebDriverUtil.pausetest(2000);
        WebDriverUtil.select(driver, DRIVER_TYPE, 3);
        WebDriverUtil.pausetest(2000);
        WebDriverUtil.action(driver, SAVE);
        Assert.assertTrue(ObjectUtils.isNotEmpty(SAVE));
        WebDriverUtil.pausetest(2000);
        WebElement dispatchBord = driver.findElement(By.xpath(DISPATCH_BORD));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", dispatchBord);
        Assert.assertTrue(ObjectUtils.isNotEmpty(DISPATCH_BORD));
    }
}
