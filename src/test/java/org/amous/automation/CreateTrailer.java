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

import static org.amous.constant.AmousXpathKeys.CREATE_TRAILER.*;

public class CreateTrailer {

    public void createTrailer(ChromeDriver driver) {
        WebElement fleetTreilerPage = driver.findElement(By.xpath(FLEET_DRIVER_PAGE));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", fleetTreilerPage);
        WebDriverUtil.wait(driver, TREE_DOTS, Duration.ofSeconds(1000));
        WebElement treeDots = driver.findElement(By.xpath(TREE_DOTS));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", treeDots);
        WebElement createNewTreiler = driver.findElement(By.xpath(CREATE_NEW_TREILER));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", createNewTreiler);
        driver.findElement(By.xpath(ADD_NEW_TRAILER));
        driver.findElement(By.xpath(TREILER_ID)).sendKeys("Treiler_A" + new Random().nextInt(999));
        WebDriverUtil.pausetest(2000);
        Select dropdown = new Select(driver.findElement(By.xpath(TREILER_TYPE)));
        List<WebElement> dd = dropdown.getOptions();
        int index = 0;
        if (dd.size() > 1) {
            Random rand = new Random();
            index = ((Random) rand).nextInt(15);
            if (index >= 2) {
                dropdown.selectByIndex(index);
            }
        }
        WebDriverUtil.action(driver, SUBMIT);
        WebDriverUtil.pausetest(2000);
        driver.findElement(By.xpath(SERIAL_NUMBER)).sendKeys("4564567" + new Random().nextInt(999999999));
        WebDriverUtil.action(driver, VIN_LOOK_UP);
        WebDriverUtil.pausetest(3000);
        WebDriverUtil.action(driver, UPDATE);
        WebDriverUtil.pausetest(4000);
        WebElement dispatchBord = driver.findElement(By.xpath(DISPATCH_BORD));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", dispatchBord);
        Assert.assertTrue(ObjectUtils.isNotEmpty(DISPATCH_BORD));

    }
}
