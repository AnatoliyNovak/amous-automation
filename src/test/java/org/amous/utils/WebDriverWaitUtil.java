package org.amous.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverWaitUtil {

    public static void waitThanClick(ChromeDriver driver, String waitingPage) {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(9999999));
        WebElement element2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(waitingPage)));
        element2.click();
    }
//    test
}
