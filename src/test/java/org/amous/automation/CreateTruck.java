package org.amous.automation;

import org.amous.utils.WebDriverUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;

import static org.amous.constant.AmousXpathKeys.CREATE_TRUCK.*;

public class CreateTruck {


    public void createTruck(ChromeDriver driver) {
        WebElement fleetDriverPage = driver.findElement(By.xpath(FLEET_DRIVERPAGE));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", fleetDriverPage);
        WebDriverUtil.wait(driver, TREEDOTS, Duration.ofSeconds(1000));
        WebElement treeDots = driver.findElement(By.xpath(TREEDOTS));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", treeDots);
        driver.findElement(By.xpath(CREATE_NEW_TRUCK));
        driver.findElement(By.xpath(TRUCK_ID)).sendKeys("Truck_A" + new Random().nextInt(9999));
        WebDriverUtil.select(driver, TRUCK_TYPE, 3);
        WebDriverUtil.waitAndClick(driver, SUBMIT, Duration.ofSeconds(5000));
        WebDriverUtil.pausetest(2000);
        driver.findElement(By.xpath(SERIAL_NUMBER)).sendKeys("4564567" + new Random().nextInt(999999999));
        WebDriverUtil.action(driver, VIN_LOOK_UP);
        WebDriverUtil.pausetest(3000);
        WebDriverUtil.action(driver, UPDATE);
        WebElement dispatchBord = driver.findElement(By.xpath(DISPATCH_BORD));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", dispatchBord);
        Assert.assertTrue(ObjectUtils.isNotEmpty(DISPATCH_BORD));
    }
}
