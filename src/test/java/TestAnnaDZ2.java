import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnaDZ2 {

    WebDriver driver;

    @BeforeTest
    public void setupDriver() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://avtogrand.com.ua/ua/");

    }

    @Test
    public void myTest1() throws InterruptedException {


        WebElement search = driver.findElement(By.id("searchinput"));
        search.sendKeys("перетворювач іржі тригер skadi");


        WebElement submitButton = driver.findElement(By.xpath("//button[@class=\"btn btn-default btn-lg button-search\"]"));
        submitButton.click();

        WebElement name = driver.findElement(By.xpath("//h4"));

        Assert.assertEquals(name.getText(),"ПЕРЕТВОРЮВАЧ ІРЖІ ТРИГЕР 500 МЛgit --version ЦИНКАР SKADI");

        Thread.sleep(3000);

    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
