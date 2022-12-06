import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Exceptions {
    WebDriver driver;


    @BeforeMethod
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get("https://demoqa.com/alerts ");
        WebElement button = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        button.click();


        // invoke TimeOutException exception
        // მარტო გამოძახება ეწერა, ასე რომ დავტოვე ასე, დანარჩენები ცალ-ცალკე შევამოწმე და აგდებს საჭირო ექსეფშენებს
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());

        // Try to avoid NoAlertPresentException and Handle possible exception
        try {
            driver.switchTo().alert().accept();

        } catch (NoAlertPresentException e) {
            System.out.println("no alert");
        }

        //Try to invoke StaleElementReferenceException
        driver.navigate().refresh();
        button.click();


    }

    @AfterMethod
        public void after() {
        driver.quit();
    }
}
