import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CommandsTest {
    @Test
    public void firstTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(" http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();

        WebElement button = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        button.click();
        WebElement input = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        System.out.println("isEnabled " + input.isEnabled());
        WebElement text = driver.findElement(By.xpath("//*[@id=\"message\"]"));
        Assert.assertEquals(text.getText(), "It's enabled!");
        Assert.assertEquals(button.getText(), "Disabled");
        input.sendKeys("Bootcamp");
        input.clear();
        driver.close();


        }
    @Test
    public void SecondtTest () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();
        int a = driver.findElement(By.id("column-a")).getLocation().getY();
        int b = driver.findElement(By.id("column-b")).getLocation().getY();
        org.testng.Assert.assertEquals(a, b);
        driver.close();


    }
}
