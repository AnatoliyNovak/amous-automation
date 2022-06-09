package org.amous.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateTrailer {

    public final String FLEETDRIVERPAGE = "//*[@id=\"app-container\"]/div/div/div/div[1]/div/div[1]/div[2]/div[1]/div[7]";
    public void createTrailer(ChromeDriver driver) {
        WebElement fleetTreilerPage = driver.findElement(By.xpath(FLEETDRIVERPAGE));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", fleetTreilerPage);
    }
}
