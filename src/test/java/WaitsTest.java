import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WaitsTest {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test(){
        driver.get("https://demoqa.com/progress-bar");
        WebElement start = driver.findElement(By.id("startStopButton"));
        start.click();
        WebElement progress = driver.findElement(By.xpath("//*[@id=\"progressBar\"]/div"));
        WebDriverWait wait=new WebDriverWait(driver, 20);
        if (wait.until(ExpectedConditions.attributeToBe(progress, "aria-valuenow", "100"))){
            System.out.println("100%");
        }

    }

    @AfterMethod
    public void after (){
        driver.quit();
    }

}
