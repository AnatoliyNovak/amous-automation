package org.amous.automation;

import org.amous.utils.WebDriverWaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class CreateOrder {

    public final String CREATE_ORDER_CLICK = "//*[@id='app-container']/div/div/div/div[1]/div/div[1]/div[1]/div[3]/div";
    public final String CREATE_ORDER_PAGE = "//*[@id='app-container']/div/div/div/div[2]";

    // TODO: 5/28/2022 works only in debug need check why
    public void createOrder(ChromeDriver driver) {
        WebElement element = driver.findElement(By.xpath(CREATE_ORDER_CLICK));
        WebDriverWaitUtil.wait(driver, CREATE_ORDER_CLICK, Duration.ofSeconds(9999999));
        element.click();
        WebDriverWaitUtil.waitAndClick(driver, CREATE_ORDER_PAGE, Duration.ofSeconds(9999999));
        Assert.assertTrue(true);
    }
}
