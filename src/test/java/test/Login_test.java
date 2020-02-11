package test;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
//login test
// just modified
public class Login_test {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void loginTest(){
driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);
String title = driver.getTitle();
        Assert.assertEquals(title,"Web Orders");
    }

    @Test
    public void negativeloginTest(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Testera");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("testa"+ Keys.ENTER);

        Assert.assertEquals(driver.getTitle(),"Web Orders");
    }
    @AfterMethod
    public void cleanup(){
driver.close();
    }
    @Test
    public void logout(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);
        driver.findElement(By.id("ctl00_logout")).click();
        String title = driver.getTitle();

    }
}
