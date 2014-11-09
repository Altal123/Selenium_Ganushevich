package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by c2613 on 07.11.20pu14.
 */
public class GoogleSearchTest {

    WebDriver driver;

    //Preconditions
    @BeforeClass
    public void setUp(){

        driver = new FirefoxDriver();
        //sets implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Maximize a windows size
        driver.manage().window().maximize();

        //opens a url
        driver.get("https://google.com.ua");

    }

    @Test
    public void searchTest(){

        //find element by name
        WebElement searchField = driver.findElement(By.name("q"));

        //send some text into an input field
        searchField.sendKeys("Selenium");

        //Find first link with specified result
        WebElement seleniumLink = driver.findElement(By.xpath(".//*[@id='rso']/div[2]/li[1]/div/h3/a"));

        //Verifies result
        Assert.assertEquals(seleniumLink.getText().toString().contains("Selenium"), true);

    }

    @AfterClass
    public void tearDown(){
        //Closes a browser
        driver.quit();
    }
}
