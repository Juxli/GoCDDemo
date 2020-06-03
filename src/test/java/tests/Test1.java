package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test1 {
    @Test
    public void Browser() throws InterruptedException {
        // Chrome testing
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver dr = new ChromeDriver();

        // Firefox testing
//        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
//        WebDriver dr = new FirefoxDriver();

        dr.manage().window().maximize();
        dr.get("https://www.baidu.com");
        Thread.sleep(2000);
        dr.findElement(By.id("kw")).clear();
        dr.findElement(By.id("kw")).sendKeys("selenium");
        dr.findElement(By.id("su")).click();
        dr.quit();
    }

}
