import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
    WebDriver driver;

    public CrossBrowserTest() {
    }

    @BeforeMethod
    @Parameters("browser")
    public void beforeTest(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
            this.driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            this.driver = new EdgeDriver();
            this.driver.manage().window().maximize();
        } else {
            System.out.println("incorrect browser");
        }

    }

    @Test
    public void testOne() {
        this.driver.get("http://webdriveruniversity.com/To-Do-List/index.html ");
        Actions action = new Actions(this.driver);
        WebElement practiceMagic = this.driver.findElement(By.xpath("//li[contains(text(), 'Practice magic')]"));
        action.moveToElement(practiceMagic).build().perform();
        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        js.executeScript("arguments[0].click()", new Object[]{practiceMagic});
    }

    @Test
    public void testTwo() {
        this.driver.get("http://webdriveruniversity.com/Scrolling/index.html ");
        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        WebElement leftBox = this.driver.findElement(By.xpath("//div[@class='col-lg-6']"));
        js.executeScript("arguments[0].scrollIntoView();", new Object[]{leftBox});
        String innerText = js.executeScript("return document.documentElement.innerText;", new Object[0]).toString();
        if (innerText.contains(leftBox.getText())) {
            System.out.println("true");
        }

    }

    @AfterMethod
    public void after() {
        this.driver.quit();
    }
}