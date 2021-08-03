package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;


        private static void initializeChromeDriver() {
            System.setProperty("webdriver.chrome.driver", "D:\\java\\Driver\\chromedriver.exe");
        }

        public static WebDriver getChromeDriver() {
            initializeChromeDriver();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return driver;
        }
   /*
//    ---WebDriverManager---
    private static void initializeChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    public static WebDriver getChromeDriver() {
        initializeChromeDriver();
        return driver;
    }
*/
}