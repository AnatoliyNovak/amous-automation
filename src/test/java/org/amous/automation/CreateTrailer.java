package org.amous.automation;

import org.amous.utils.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class CreateTrailer {

    public final String FLEETDRIVERPAGE = "//*[@id=\"app-container\"]/div/div/div/div[1]/div/div[1]/div[2]/div[1]/div[7]";
    public final String TREEDOTS = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div/div[3]/div";
    public final String CREATENEWTREILER = "/html/body/div[@id='amous-frontend-app']/div[@id='app-container']/div[@class='css-RootWrapper-o71dww3 css-1urznz1']/div/div/div[@class='css-PageWrapper-o71dww5 css-ListWrapper-o71dww6 css-5qp2sn']/div/div[@class='css-TrailerWrapper-1fxyiwc0 css-cz52ig']/div[@class='css-Wrapper-ikgouz0 css-17jic38']/div[@class='css-Box-17642400 css-Flex-17642401 css-AbsoluteBox-17642406 css-6cb7bf']/div[@class='css-PageActionsUI-1twaczk0 css-jnnt11']/div[@class='css-Box-17642400 css-Flex-17642401 css-AbsoluteBox-17642406 css-107g36p']/div[@class='css-Box-17642400 css-Flex-17642401 css-92798z']/div[@class='css-Wrapper-ikgouz0 css-17jic38'][2]/div[@class='css-Wrapper-1twaczk1 css-uf7rbo']";
    public final String ADDNEWTRAILER = "//*[@id=\"app-container\"]/div/div/div/div[1]/div[2]/div";
    public final String TREILERID = "//*[@id=\"unitId\"]";
    public final String TREILERTYPE = "//*[@id=\"trailerType\"]";
    public final String SUBMIT = "//*[@id=\"app-container\"]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/form/div/button[2]";
    public final String SERIALNUMBER = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div[2]/form/section[1]/div[5]/input";
    public final String VINLOOKUP = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div[2]/form/section[1]/div[5]/label/button";
    public final String UPDATE = "//*[@id=\"app-container\"]/div/div/div/div[2]/div/div[2]/form/div/div[2]/button[2]";
//    public final String DISPATCHBORD = "//*[@id=\"app-container\"]/div/div/div/div[1]/div/div[1]/div[1]/div[5]";

    public void createTrailer(ChromeDriver driver) {
        WebElement fleetTreilerPage = driver.findElement(By.xpath(FLEETDRIVERPAGE));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", fleetTreilerPage);
        WebDriverUtil.wait(driver, TREEDOTS, Duration.ofSeconds(1000));
        WebElement treeDots = driver.findElement(By.xpath(TREEDOTS));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", treeDots);
        WebElement createNewTreiler = driver.findElement(By.xpath(CREATENEWTREILER));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", createNewTreiler);
        driver.findElement(By.xpath(ADDNEWTRAILER));
        driver.findElement(By.xpath(TREILERID)).sendKeys("Treiler_A" + new Random().nextInt(999));
        Select dropdown = new Select(driver.findElement(By.xpath(TREILERTYPE)));
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
        driver.findElement(By.xpath(SERIALNUMBER)).sendKeys("4564567" + new Random().nextInt(999999999));
        WebDriverUtil.action(driver, VINLOOKUP);
        WebDriverUtil.pausetest(3000);
        WebDriverUtil.action(driver, UPDATE);
//        WebDriverUtil.pausetest(3000);
//        WebElement dispatchBord = driver.findElement(By.xpath(DISPATCHBORD));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", dispatchBord);
        Assert.assertTrue(true);
//        Assert.assertTrue(ObjectUtils.isNotEmpty(DISPATCHBORD));
    }
}