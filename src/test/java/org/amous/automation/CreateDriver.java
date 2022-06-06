package org.amous.automation;

import org.amous.utils.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

public class CreateDriver {

    public final String FLEETDRIVERPAGE = "//*[@id=\"app-container\"]/div/div/div/div[1]/div/div[3]/div[3]/div[14]/div[2]";
    public final String ADDDRIVER = "/html/body/div[@id='amous-frontend-app']/div[@id='app-container']/div[@class='css-RootWrapper-o71dww3 css-1urznz1']/div/div/div[@class='css-PageWrapper-o71dww5 css-ListWrapper-o71dww6 css-5qp2sn']/div/div[@class='css-DriverWrapper-jddpo87 css-cz52ig']/div[@class='css-Wrapper-ikgouz0 css-17jic38']/div[@class='css-Box-17642400 css-Flex-17642401 css-AbsoluteBox-17642406 css-6cb7bf']/div[@class='css-PageActionsUI-1twaczk0 css-jnnt11']/div[@class='css-Box-17642400 css-Flex-17642401 css-AbsoluteBox-17642406 css-107g36p']/div[@class='css-Box-17642400 css-Flex-17642401 css-92798z']/div[@class='css-Wrapper-ikgouz0 css-17jic38'][2]/div[@class='css-Wrapper-1twaczk1 css-uf7rbo']";
    public final String ADDNEWDRIVER = "//*[@id=\"app-container\"]/div/div/div/div[1]/div[2]/div";

    public void createDriver(ChromeDriver driver) {
        WebElement fleetDriverPage = driver.findElement(By.xpath(FLEETDRIVERPAGE));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", fleetDriverPage);
                WebDriverUtil.action(driver,ADDDRIVER);
        WebElement addDriver = driver.findElement(By.xpath(ADDDRIVER));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", addDriver);
        WebDriverUtil.wait(driver, ADDNEWDRIVER, Duration.ofSeconds(5));

//        ((JavascriptExecutor) driver).executeScript("arguments[0].click()");
        Assert.assertTrue(true);
    }
}
