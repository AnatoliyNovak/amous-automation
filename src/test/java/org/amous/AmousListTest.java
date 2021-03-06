package org.amous;

import org.amous.automation.*;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import org.testng.annotations.*;

public class AmousListTest {

    public static final String CHROME_DRIVER_PATH = "C:\\Program Files\\Google\\chromedriver.exe";
    public static final String HTTPS_AMOUS_TMS_CF_LOGIN_URL = "https://amoustms.cf/login";
    public static ChromeDriver driver;

    @BeforeMethod
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

    @Test(priority = 5, testName = "createOrder")
    public void createOrderTest() {
        CreateOrder createOrder = new CreateOrder();
        createOrder.createOrder(driver);
    }

    @Test(priority = 1, testName = "createDriver")
    public void createDriverTest() {
        CreateDriver createDriver = new CreateDriver();
        createDriver.createDriver(driver);
    }

    @Test(priority = 2, testName = "createTruck")
    public void createTruckTest() {
        CreateTruck createTruck = new CreateTruck();
        createTruck.createTruck(driver);
    }

    @Test(priority = 3, testName = "createTrailer")
    public void createTrailer() {
        CreateTrailer createTrailer = new CreateTrailer();
        createTrailer.createTrailer(driver);
    }
    @Test(priority = 4, testName = "createCarrier")
    public void createCarrier() {
       CreateCarrier createCarrier = new CreateCarrier();
      createCarrier.createCarrier(driver);
   }

    @AfterMethod ()
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
