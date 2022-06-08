package org.amous;

import org.amous.automation.CreateDriver;
import org.amous.automation.CreateOrder;
import org.amous.automation.CreateTruck;
import org.amous.automation.LoginPage;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmousListTest {

    public static final String CHROME_DRIVER_PATH = "C:\\Drivers\\chromedriver.exe";
    public static final String HTTPS_AMOUS_TMS_CF_LOGIN_URL = "https://amoustms.cf/login";
    public static ChromeDriver driver;

    @BeforeClass
    public void loginAndSetUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(960, 800));
        driver.get(HTTPS_AMOUS_TMS_CF_LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver);
        Assert.assertTrue(ObjectUtils.isNotEmpty(loginPage));
    }

    //        @Test(priority = 0)
//    public void createOrderTest() {
//        CreateOrder createOrder = new CreateOrder();
//        createOrder.createOrder(driver);
//    }
//    @Test(priority = 2 )
//    public void createDriverTest() {
//        CreateDriver createDriver = new CreateDriver();
//        createDriver.createDriver(driver);
//
//    }
    @Test(priority = 1)
    public void createTruckTest() {
        CreateTruck createTruck = new CreateTruck();
        createTruck.createTruck(driver);

    }

//    @AfterClass
//    public static void afterTests() {
//        driver.quit();
//    }

}