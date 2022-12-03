import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSexecutor {
    WebDriver driver;


    @BeforeMethod
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testOne() {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html ");
        Actions action = new Actions(driver);
        WebElement practiceMagic = driver.findElement(By.xpath("//li[contains(text(), 'Practice magic')]"));
        action.moveToElement(practiceMagic).build().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", practiceMagic);

    }
    @Test
    public void testTwo(){
        driver.get("http://webdriveruniversity.com/Scrolling/index.html ");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement  leftBox = driver.findElement(By.xpath("//div[@class='col-lg-6']"));
        js.executeScript("arguments[0].scrollIntoView();", leftBox);
        String innerText =  js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(innerText);
        // აქ როგორც გავიგე, მარცხენა ბოქსის ტექსტის ვალიდაცია გვინდოდა
        if (innerText.contains(leftBox.getText())){
            System.out.println("true");
        }


    }


    @AfterMethod
    public void after(){
        driver.quit();
  }


}
