package org.amous.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class WebDriverUtil {


    public static void waitAndClick(ChromeDriver driver, String waitingPage, Duration timeout) {
        wait(driver, waitingPage, timeout).click();
    }

    public static WebElement wait(ChromeDriver driver, String waitingPage, Duration timeout) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(By.xpath(waitingPage)));
    }

    public static void select(ChromeDriver driver, String xpath, int index) {
        Select se = new Select(driver.findElement(By.xpath(xpath)));
        se.selectByIndex(index);
    }

    public static void action(ChromeDriver driver, String xpath) {
        WebElement clickable = wait(driver, xpath, Duration.ofSeconds(100));
        new Actions(driver)
                .click(clickable)
                .perform();
    }

    public static void pausetest(long sleeptime) {
        try {
            Thread.sleep(sleeptime);
        } catch (InterruptedException ex) {

        }

    }
}
