package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver;
    String driver= "chrome";

    @BeforeMethod
    public void setUp() throws Exception {
        if (driver=="chrome") {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-notifications");
            options.addArguments("ignore-certificate-errors");
            options.addArguments("disable-popup-blocking");
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(options);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
            webDriver.get("https://www.trendyol.com/");
            webDriver.findElement(By.className("modal-close")).click();
        }
        else if (driver=="firefox")
        {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
            webDriver.get("https://www.trendyol.com/");
            webDriver.findElement(By.className("modal-close")).click();
        }
        else{
            throw new Exception("Geçerli bir driver seçiniz!");
        }
    }
    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
