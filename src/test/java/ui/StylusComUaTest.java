package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Aleksandr Ganushevich on 09.11.2014.
 */
public class StylusComUaTest {

    WebDriver driver;

    @BeforeClass
    public void before(){

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("http://stylus.com.ua");

    }

    @Test
    public void searchElement(){

        //Verify that http://stylus.com.ua/ is opened??
        Assert.assertEquals(driver.findElement(By.className("tel")).getText().contains("520-520-0"), true);

        WebElement element = getWebElement("search_text");

        //write text to wanna be found
        getSetKeys(element, "Sony Z2");

        //click on button search
        driver.findElement(By.id("button")).click();

        //verify that Sony Z2 will be found
        WebElement foundLink = driver.findElement(By.xpath(".//*[@id='col1_content']/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[2]/span[1]"));

        //Verifies results
        Assert.assertEquals(foundLink.getText().contains("Код товара: 198717"), true);

        //click on first link of results
        driver.findElement(By.xpath(".//*[@id='col1_content']/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[2]/h4/a")).click();

        //scroll down page on 300 px
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,300)", "");

        //Click characteristics tab
        driver.findElement(By.xpath(".//*[@id='menulink']/ul/li[1]/a")).click();

        //verify that section "Программные функции" will be found
        foundLink = driver.findElement(By.xpath(".//*[@id='col1_content']/div[4]/div[1]/div[5]/table/tbody/tr[21]/td/div/p/strong"));
        Assert.assertEquals(foundLink.getText().toString().contains("Программные функции"), true);

        //verify that section "Интернет-доступ" will be found
        foundLink = driver.findElement(By.xpath(".//*[@id='col1_content']/div[4]/div[1]/div[5]/table/tbody/tr[29]/td[1]"));
        Assert.assertEquals(foundLink.getText().toString().contains("Интернет-доступ"), true);

        //verify that section "HTML, HTML5, Adobe Flash, RSS" will be found
        foundLink = driver.findElement(By.xpath(".//*[@id='col1_content']/div[4]/div[1]/div[5]/table/tbody/tr[29]/td[2]/div"));
        Assert.assertEquals(foundLink.getText().toString().contains("HTML, HTML5, Adobe Flash, RSS"), true);

    }

    private void getSetKeys(WebElement element, String s) {
        element.clear();
        element.sendKeys(s);
    }

    private WebElement getWebElement(String search_text) {
        return driver.findElement(By.id(search_text));
    }

    @AfterClass
    public void after(){

        driver.quit();
    }

}
