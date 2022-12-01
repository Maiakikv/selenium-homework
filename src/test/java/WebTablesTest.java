import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void tables(){
        driver.get("http://techcanvass.com/Examples/webtable.html");

        for(int rowno=4;rowno<=4;rowno++)
        {
            for(int colno=3;colno<=3;colno++)
            {
                System.out.println(driver.findElement(By.xpath("//*[@id='t01']/tbody/tr[" + rowno + "]/td[" + colno + "]")).getText());

            }
        }
    }


    @AfterMethod
    public void after(){
        driver.quit();
    }
}
