import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebElementsTest {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i = 0; i < 3; i++) {
            addElement.click();
        }
        WebElement lastElement = driver.findElement(By.xpath("//div[@id='elements']//button[3]"));
        System.out.println(lastElement.getText());

        List<WebElement> elements = driver.findElements(By.cssSelector("button[class^='added']"));
        System.out.println(elements.get(elements.size()-1).getText());

        WebElement lastElement2 = driver.findElement(By.xpath("//button[contains(@class,'manually')][text()='Delete'][3]"));
        System.out.println(lastElement2.getText());
    }

    @Test
    public void testTwo () {
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        WebElement loremElement = driver.findElement(By.xpath("//td[text() = 'Apeirian9']//preceding::td[1]"));
        System.out.println(loremElement.getText());
        WebElement nextElement = driver.findElement(By.xpath("//td[text() = 'Apeirian9']//following::td[1]"));
        System.out.println(nextElement.getText());
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }




}

