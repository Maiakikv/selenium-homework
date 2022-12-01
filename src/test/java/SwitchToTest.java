import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class SwitchToTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void switchTo() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement text = driver.findElement(By.xpath("//body[@id='tinymce']/child::p"));
        text.clear();
        text.sendKeys("Here Goes");
        driver.switchTo().defaultContent();
        WebElement alignCenter = driver.findElement(By.xpath("//button[@title='Align center']"));
        alignCenter.click();
    }

    @Test
    public void alerts(){
        driver.get("https://demoqa.com/alerts");
        WebElement alert = driver.findElement(By.id("alertButton"));
        alert.click();
        driver.switchTo().alert().accept();


    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}
