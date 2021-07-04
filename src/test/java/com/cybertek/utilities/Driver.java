package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    /*
    Creating the private constructor so this class object
    is not reachable from outside
     */
    private Driver() {}

    /*
    making our driver instance privet so that is not reachable from out side of the class
    we make it static, because we want it to run before everything else we will use it in static method
     */
    private static WebDriver driver;

    /*
    creating reusable method that will return same driver instance everytime we call it
     */

    public static WebDriver getDriver() {

        if (driver ==  null) {
            /*
            we read our browser type from configuration.property file using
            .getProperty method we creating in configurationReader class
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browser type our switch statement will determine to open the specific type of browser and driver
             */
            switch (browserType){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }
        }
        /*
        same driver instance will be return everytime, we call  driver.getDriver(); method
         */
        return driver;
    }

    /*
    this method makes sure we have some form of driver sesion or driver id has  either null or not null it must exist

     */
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}