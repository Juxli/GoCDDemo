package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.*;


public class Test1 {
    WebDriver dr;

    @Parameters({"browser", "url"})
    @BeforeTest
    public void setupEnv(String browser, String url){
        if(browser.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            dr = new ChromeDriver();

        }
        else if (browser.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
            dr = new FirefoxDriver();
        }

        dr.get(url);
        dr.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        dr.findElement(By.id("kw")).clear();
        dr.findElement(By.id("kw")).sendKeys("selenium");
        sleep(2000);
        dr.findElement(By.id("su")).click();
    }
    @Test
    public void test2() throws InterruptedException {
        dr.findElement(By.id("kw")).clear();
        sleep(2000);
        dr.findElement(By.id("kw")).sendKeys("java");
        dr.findElement(By.id("su")).click();
    }

    @AfterTest
    public void quitBrowser(){
        dr.quit();
    }

}
