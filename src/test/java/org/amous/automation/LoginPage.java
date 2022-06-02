package org.amous.automation;

import org.amous.utils.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginPage {

    public static final String DISPATCH_BOARD_PAGE = "//div[@title='Dispatch Board']";
    public static final String SING_IN = "//*[@id='app-container']/div/div/div[1]/div[1]/form/button";
    public static final String LOGIN_PAGE = "//*[@id=\"username\"]";

    public void login(ChromeDriver driver) {
        WebElement webElement = WebDriverUtil.wait(driver, LOGIN_PAGE, Duration.ofSeconds(15));
        webElement.sendKeys("NLC");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.xpath(SING_IN)).click();
        WebDriverUtil.waitAndClick(driver, DISPATCH_BOARD_PAGE, Duration.ofSeconds(9999999));
    }

}
