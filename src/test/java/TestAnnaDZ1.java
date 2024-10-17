import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnaDZ1 {

    WebDriver driver;

    @BeforeTest
    public void setupDriver() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://avtogrand.com.ua/ua/login/");

    }

    @Test
    public void myTest() throws InterruptedException {


        WebElement input1 = driver.findElement(By.id("input-email"));
        input1.sendKeys("anna.smirnova0502@gmail.com");

        WebElement input2 = driver.findElement(By.id("input-password"));
        input2.sendKeys("test911");
        

        WebElement submitButton = driver.findElement(By.xpath("//input[@class=\"btn btn-primary-login\"]"));
        submitButton.click();

        WebElement text = driver.findElement(By.xpath("//h2"));

        Assert.assertEquals(text.getText(),"Особистий кабінет");

Thread.sleep(3000);

    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
