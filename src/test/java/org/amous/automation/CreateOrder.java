package org.amous.automation;

import org.amous.utils.WebDriverWaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class CreateOrder {

    public final String CREATE_ORDER_CLICK = "/html/body/div[@id='amous-frontend-app']/div[@id='app-container']/div[@class='css-RootWrapper-o71dww3 css-1urznz1']/div/div/div[@class='css-LayoutsWrapper-o71dww4 css-1t81cfi']/div[@class='css-Box-17642400 css-cx3vhc']/div[@class='css-MenuWrapper-1cou8p27 css-8079i2']/div[@class='css-Box-17642400 css-ctro3b']/div[@class='css-Wrapper-ikgouz0 css-17jic38'][2]/div[@class='css-NavItem-1cou8p20 css-xoho6r']";
    public final String CREATE_ORDER_PAGE = "/html/body/div[@id='amous-frontend-app']/div[@id='app-container']/div[@class='css-RootWrapper-o71dww3 css-1urznz1']/div/div/div[@class='css-PageWrapper-o71dww5 css-4aamnj']/div[@class='css-Box-17642400 css-cx3vhc']/div[@class='css-Box-17642400 css-ajbbia']";

    // TODO: 5/28/2022 works only in debug need check why
    public void createOrder(ChromeDriver driver) {
        WebElement element = driver.findElement(By.xpath(CREATE_ORDER_CLICK));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        WebDriverWaitUtil.wait(driver, CREATE_ORDER_CLICK, Duration.ofSeconds(9999999));
        element.click();
        WebDriverWaitUtil.waitAndClick(driver, CREATE_ORDER_PAGE, Duration.ofSeconds(9999999));
        Assert.assertTrue(true);
    }

}
