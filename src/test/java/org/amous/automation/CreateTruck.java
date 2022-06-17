package org.amous.automation;

import org.amous.utils.WebDriverUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.amous.constant.AmousXpathKeys.CREATE_TRUCK.*;

public class CreateTruck {


    public void createTruck(ChromeDriver driver) {
        WebElement fleetDriverPage = driver.findElement(By.xpath(FLEET_DRIVERPAGE));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", fleetDriverPage);
        WebDriverUtil.pausetest(3000);
        WebElement treeDots = driver.findElement(By.xpath(TREE_DOTS));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", treeDots);
        WebElement createNewTruck = driver.findElement(By.xpath(CREATE_NEW_TRUCK));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", createNewTruck);
        WebDriverUtil.pausetest(2000);
        driver.findElement(By.xpath(TRUCK_ID)).sendKeys("Truck_A" + new Random().nextInt(9999));
        WebDriverUtil.pausetest(2000);
        Select dropdown = new Select(driver.findElement(By.xpath(TRUCK_TYPE)));
        List<WebElement> dd = dropdown.getOptions();
        int index = 0;
        if (dd.size() > 1) {
            Random rand = new Random();
            index = ((Random) rand).nextInt(4);
            if (index >= 1) {
                dropdown.selectByIndex(index);
            }
            WebDriverUtil.waitAndClick(driver, SUBMIT, Duration.ofSeconds(5000));
            WebDriverUtil.pausetest(2000);
            driver.findElement(By.xpath(SERIAL_NUMBER)).sendKeys("4564567" + new Random().nextInt(999999999));
            WebDriverUtil.action(driver, VIN_LOOK_UP);
            WebDriverUtil.pausetest(3000);
            WebDriverUtil.action(driver, UPDATE);
            WebDriverUtil.pausetest(3000);
            WebElement dispatchBord = driver.findElement(By.xpath(DISPATCH_BORD));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click()", dispatchBord);
            Assert.assertTrue(ObjectUtils.isNotEmpty(DISPATCH_BORD));
        }
    }
}