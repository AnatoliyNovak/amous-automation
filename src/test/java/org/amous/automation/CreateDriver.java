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

public class CreateDriver {

    public final String FLEETDRIVERPAGE = "//*[@id=\"app-container\"]/div/div/div/div[1]/div/div[3]/div[3]/div[14]/div[2]";
    public final String TREEDOTS = "/html/body/div[@id='amous-frontend-app']/div[@id='app-container']/div[@class='css-RootWrapper-o71dww3 css-1urznz1']/div/div/div[@class='css-PageWrapper-o71dww5 css-ListWrapper-o71dww6 css-5qp2sn']/div/div[@class='css-DriverWrapper-jddpo87 css-cz52ig']/div[@class='css-Wrapper-ikgouz0 css-17jic38']/div[@class='css-Box-17642400 css-Flex-17642401 css-AbsoluteBox-17642406 css-6cb7bf']/div[@class='css-PageActionsUI-1twaczk0 css-jnnt11']";
    public final String ADDDRIVER = "/html/body/div[@id='amous-frontend-app']/div[@id='app-container']/div[@class='css-RootWrapper-o71dww3 css-1urznz1']/div/div/div[@class='css-PageWrapper-o71dww5 css-ListWrapper-o71dww6 css-5qp2sn']/div/div[@class='css-DriverWrapper-jddpo87 css-cz52ig']/div[@class='css-Wrapper-ikgouz0 css-17jic38']/div[@class='css-Box-17642400 css-Flex-17642401 css-AbsoluteBox-17642406 css-6cb7bf']/div[@class='css-PageActionsUI-1twaczk0 css-jnnt11']/div[@class='css-Box-17642400 css-Flex-17642401 css-AbsoluteBox-17642406 css-107g36p']/div[@class='css-Box-17642400 css-Flex-17642401 css-92798z']/div[@class='css-Wrapper-ikgouz0 css-17jic38'][2]/div[@class='css-Wrapper-1twaczk1 css-uf7rbo']";
    public final String ADDNEWDRIVER = "//*[@id=\"app-container\"]/div/div/div/div[1]/div[2]/div";
    public final String FIRSTNAME = "//*[@id=\"firstName\"]";
    public final String LASTNAME = "//*[@id=\"lastName\"]";
    public final String LOGINID = "//*[@id=\"loginId\"]";
    public final String PASSWORD = "//*[@id=\"password\"]";
    public final String EMAIL = "//*[@id=\"email\"]";
    public final String SELECTPERMISSIONS = "//*[@id=\"app-container\"]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/form/section/div[6]/div[2]/div";
    public final String SUBMIT = "//*[@id=\"app-container\"]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/form/div/button[2]";

    public void createDriver(ChromeDriver driver) {

        WebElement fleetDriverPage = driver.findElement(By.xpath(FLEETDRIVERPAGE));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", fleetDriverPage);
        WebDriverUtil.wait(driver, TREEDOTS, Duration.ofSeconds(1000));
        WebElement treeDots = driver.findElement(By.xpath(TREEDOTS));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", treeDots);
        WebElement addDriver = driver.findElement(By.xpath(ADDDRIVER));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", addDriver);
        WebElement newAddDriver = driver.findElement(By.xpath(ADDNEWDRIVER));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", newAddDriver);
        driver.findElement(By.xpath(FIRSTNAME)).sendKeys("Driver" + new Random().nextInt(2000));
        driver.findElement(By.xpath(LASTNAME)).sendKeys("Automation" + new Random().nextInt(2000));
        driver.findElement(By.xpath(LOGINID)).sendKeys("LoginId" + new Random().nextInt(2000));
        driver.findElement(By.xpath(PASSWORD)).sendKeys("1234");
        driver.findElement(By.xpath(EMAIL)).sendKeys("emaol" + new Random().nextInt(200) + "@gmail.com");
        WebElement selectCustomerClick = driver.findElement(By.xpath(SELECTPERMISSIONS));
        new Actions(driver).moveToElement(selectCustomerClick)
                .click()
                .sendKeys("Driver\n")
                .perform();
        WebElement btnSubmit = driver.findElement(By.xpath(SUBMIT));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", btnSubmit);
        Assert.assertTrue(ObjectUtils.isNotEmpty(btnSubmit));
    }
}
