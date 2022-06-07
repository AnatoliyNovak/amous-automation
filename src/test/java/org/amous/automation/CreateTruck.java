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

public class CreateTruck {

    public final String FLEETDRIVERPAGE = "//*[@id=\"app-container\"]/div/div/div/div[1]/div/div[3]/div[3]/div[14]/div[3]";
    public final String TREEDOTS = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div/div[3]/div/div/div[1]/div[3]";
    public final String CREATENEWTRUCK = "/html/body/div[@id='amous-frontend-app']/div[@id='app-container']/div[@class='css-RootWrapper-o71dww3 css-1urznz1']/div/div/div[@class='css-PageWrapper-o71dww5 css-ListWrapper-o71dww6 css-5qp2sn']/div/div[@class='css-TruckWrapper-115gt690 css-cz52ig']/div[@class='css-Wrapper-ikgouz0 css-17jic38']/div[@class='css-Box-17642400 css-Flex-17642401 css-AbsoluteBox-17642406 css-6cb7bf']/div[@class='css-PageActionsUI-1twaczk0 css-jnnt11']/div[@class='css-Box-17642400 css-Flex-17642401 css-AbsoluteBox-17642406 css-107g36p']/div[@class='css-Box-17642400 css-Flex-17642401 css-92798z']/div[@class='css-Wrapper-ikgouz0 css-17jic38'][2]/div[@class='css-Wrapper-1twaczk1 css-uf7rbo']";
    public final String TRUCKID = "//*[@id=\"unitId\"]";
    public final String TRUCKTYPE = "//*[@id=\"truckType\"]";
    public final String SUBMIT = "//*[@id=\"app-container\"]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/form/div/button[2]";
    public final String UPDATE = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div[3]/form/div/div[2]/button[2]";

    public void createTruck(ChromeDriver driver) {
        WebElement fleetDriverPage = driver.findElement(By.xpath(FLEETDRIVERPAGE));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", fleetDriverPage);
        WebDriverUtil.wait(driver, TREEDOTS, Duration.ofSeconds(1000));
        WebElement treeDots = driver.findElement(By.xpath(TREEDOTS));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", treeDots);
        WebElement createNewTruck = driver.findElement(By.xpath(CREATENEWTRUCK));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", createNewTruck);
        driver.findElement(By.xpath(TRUCKID)).sendKeys("Truck_A" + new Random().nextInt(200));
        WebDriverUtil.select(driver, TRUCKTYPE, 3);
        WebElement btnSubmit = driver.findElement(By.xpath(SUBMIT));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", btnSubmit);
        WebElement btnUpdate = driver.findElement(By.xpath(UPDATE));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", btnUpdate);
        Assert.assertTrue(ObjectUtils.isNotEmpty(btnUpdate));
    }
}