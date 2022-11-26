import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebFormsTest {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html ");
        Select drop = new Select(driver.findElement(By.id("dropdowm-menu-1")));
        drop.selectByIndex(2);
        String getText = drop.getFirstSelectedOption().getText();
        Assert.assertEquals(drop.getFirstSelectedOption().getText(), "Python");
        System.out.println("selected language is " + getText);

        WebElement check1 = driver.findElement(By.cssSelector("input[value='option-1']"));
        WebElement check2 = driver.findElement(By.cssSelector("input[value='option-2']"));
        WebElement check3 = driver.findElement(By.cssSelector("input[value='option-3']"));
        WebElement check4 = driver.findElement(By.cssSelector("input[value='option-4']"));
        if (!check1.isSelected())
            check1.click();
        if (!check2.isSelected())
            check2.click();
        if (!check3.isSelected())
            check3.click();
        if (!check4.isSelected())
            check4.click();

        WebElement radio = driver.findElement(By.cssSelector("input[value='yellow']"));
        radio.click();

        WebElement testDropDown = driver.findElement(By.id("fruit-selects"));
        Select dropdown = new Select(testDropDown);
        boolean isEnabledDropDown = driver.findElement(By.xpath("//*[@id=\"fruit-selects\"]/option[2]")).isEnabled();
        if (!isEnabledDropDown) {
            System.out.println("is Disabled");

        }

    }

    @AfterMethod
    public void after() {
        driver.quit();
    }

}
