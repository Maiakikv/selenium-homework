import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoComplete {
    WebDriver driver;

    public AutoComplete() {
    }

    @BeforeMethod
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        this.driver.get("https://www.google.com/");
        WebElement search = this.driver.findElement(By.xpath("//input[@class='gLFyf']"));
        search.sendKeys("Automation");
        List<WebElement> autoCompleteResults = this.driver.findElements(By.xpath("//ul/li[@class='sbct']"));
        System.out.println(((WebElement)autoCompleteResults.get(autoCompleteResults.size() - 1)).getText());
        WebElement lastSuggestion = (WebElement)autoCompleteResults.get(autoCompleteResults.size() - 1);
        lastSuggestion.click();
    }
    @AfterMethod
    public void after() {
        this.driver.quit();
    }
}
