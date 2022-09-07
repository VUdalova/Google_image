import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GoogleImage {
    private WebDriver driver;

    @Before
    public void profileSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikto\\OneDrive\\Робочий стіл\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void googleImage() {


        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Cat");
        searchField.submit();

        driver.findElement(By.xpath("//div/a[text()=\"Зображення\"]")).click();
        List<WebElement> images =  driver.findElements(By.xpath("//img[contains(@src, '1GtbZ8vDA')]"));
        assertFalse(images.isEmpty());
    }
}